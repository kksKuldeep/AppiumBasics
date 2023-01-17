package AppiumBasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class LongPress extends BaseClass {
	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException {

		// Actual Automation Code Start
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();

		WebElement elePeople = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
		
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) elePeople)
//				.getId(), "duration", 2000));
		longPressAction(elePeople);
		
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
		
		String sample=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
		Assert.assertEquals("Sample menu", sample);
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());

	}
}
