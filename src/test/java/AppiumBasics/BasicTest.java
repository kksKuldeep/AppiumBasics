package AppiumBasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasicTest extends BaseClass {

	@Test
	public void WifiSettingsName() throws MalformedURLException, InterruptedException {

		// Actual Automation Code Start
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[2]")).click();
		String wifiAlertTitle=driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		System.out.println(wifiAlertTitle);
		Assert.assertEquals("WiFi settings", wifiAlertTitle);
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Kuldeep");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		
		
		

	}
}
