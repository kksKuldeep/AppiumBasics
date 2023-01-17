package AppiumBasics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerceTest1 extends BaseClass{
	
	@Test
	public void AddProductToCart() throws InterruptedException
	{
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Auto User");
		driver.hideKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		// Grabbing Displayed error Toast Message
				String errorToastMsg = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("Name");
				Assert.assertEquals("Please enter your name", errorToastMsg);

		
	}

}
