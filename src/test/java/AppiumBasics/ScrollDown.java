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

public class ScrollDown extends BaseClass {
	@Test
	public void ScrollDownGesture() throws MalformedURLException, InterruptedException {

		// Actual Automation Code Start
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Scrolling Action for Specified Locations
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		//Scrolling Action for Randomly
		ScrollToEndAction();
		
			
		
			
	}
}
