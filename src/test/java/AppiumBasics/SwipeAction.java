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

public class SwipeAction extends BaseClass {
	@Test
	public void SwipeActionGesture() throws MalformedURLException, InterruptedException {

		// Actual Automation Code Start
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		//driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@focusable='true']")).getAttribute("focusable");
		
		WebElement FirstImage=driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]"));
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),"true");
		//Swipe action code 
		SwipeAction(FirstImage, "left");
		
		
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),"false");
		
		
		// Java
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//		    "left", 100, "top", 100, "width", 200, "height", 200,
//		    "direction", "left",
//		    "percent", 0.75
//		));
		
			
		
			
	}
}
