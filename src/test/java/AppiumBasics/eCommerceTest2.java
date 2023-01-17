package AppiumBasics;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerceTest2 extends BaseClass {

	@Test
	public void FillUpForm() throws InterruptedException {
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Auto User");
		driver.hideKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(3000);

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// Scroll Down Product Page to Grab Product
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Air Jordan 4 Retro\"));"));
		int productCount= driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).size();
		for (int i=0; i<productCount; i++)
		{
			String productName=driver.findElements(AppiumBy.xpath
					("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).get(i).getText();
			System.out.println(productName);
			if (productName.equals("Air Jordan 4 Retro")) 
			{
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
			}
		}
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//verify Added Product in Cart is valid from Product list
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cart']"))));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.xpath("//android.widget.TextView")), "text", "Cart"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cart']"));
		String cartProduct=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).getText();
		System.out.println("Product Addded in Cart"+cartProduct);
		Assert.assertEquals("Air Jordan 4 Retro", cartProduct);
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
	}

}
