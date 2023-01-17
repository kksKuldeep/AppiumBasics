package AppiumBasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class Assignment1 extends BaseClass {
	@Test
	public void Assignment() throws MalformedURLException, InterruptedException {

		// Actual Automation Code Start
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		//Go to Pop-up and select Radio Button
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView[@resource-id='android:id/text1'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		//Perform Cancel Pop-up with Grabbing pop-up displayed Message 
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons")).click();
		String AlertTitle=driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals("Lorem ipsum dolor sit aie consectetur adipiscing\n"
				+ "Plloaso mako nuto siwuf cakso dodtos anr koop.", AlertTitle);
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		Thread.sleep(3000);
		//Perform Text entry in Displayed pop-up Text fields
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/username_edit")).sendKeys("Appium Test");
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/password_edit")).sendKeys("123456789");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		//perform Checkbox Selection for Repeat Alarm option 
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		List<WebElement> DayCheckBox=driver.findElements(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));
		System.out.println(DayCheckBox.get(4).getText());
		DayCheckBox.get(4).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		
		
			
		
		
			
		
			
	}
}
