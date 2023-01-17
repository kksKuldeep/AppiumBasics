package AppiumBasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MIscelleniousTest extends BaseClass {

	@Test
	public void MIscelleniousAction() throws MalformedURLException, InterruptedException {
		
		//App Package & Activity >flow
		
		//Activity activity=new Activity(null, null);

		// Actual Automation Code Start

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"))
				.click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		// Device Rotation Action
		DeviceRotation landscapeRotate = new DeviceRotation(0, 0, 90);
		driver.rotate(landscapeRotate);
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[2]")).click();
		String wifiAlertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		System.out.println(wifiAlertTitle);
		Assert.assertEquals("WiFi settings", wifiAlertTitle);

		// Copy values from Text Box and paste
		driver.setClipboardText("Kuldeep");
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}
}
