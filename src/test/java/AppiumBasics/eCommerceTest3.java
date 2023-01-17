package AppiumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerceTest3 extends BaseClass{
	
	
	
	//Adding Multiple products to cart, Verify Total Amout sum, Click on Proceed action
	
	@Test
	public void VerifyProductsAndProceedToCheckout() throws InterruptedException
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
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
		//Add Products to Cart from Product List
		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).get(0).click();
		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).get(1).click();
		Thread.sleep(3000);
		 driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//com.androidsample.generalstore:id/appbar_btn_cart
		 Thread.sleep(3000);
		wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.xpath("//android.widget.TextView")), "text", "Cart"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cart']"))));
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cart']"));
		//android.widget.TextView[@text='Cart']
		List<WebElement> productPrices=driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']"));
		int prodCounts=productPrices.size();
		double totalSum=0;
		//int prodsPrices=driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")).size();
		for(int i=0;i<prodCounts ;i++)
		{
			String productAmount=productPrices.get(i).getText(); //Get Product Price value text
			//remove currency Code from Grabbed Price using Substring format with converting it to double format for Decimal point values
			//Double price=Double.parseDouble(productAmount.substring(1));
			double price=getFormattedAmount(productAmount);
		totalSum=totalSum+price;
		System.out.println(totalSum);
			
		}
		String totalAmountDisplay=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		//Double totalAmountDisplayUpdt= Double.parseDouble(totalAmountDisplay.substring(1));
		Double formattedTotalAmountDisplay=getFormattedAmount(totalAmountDisplay);
		Assert.assertEquals(totalSum, formattedTotalAmountDisplay);
		driver.findElement(AppiumBy.xpath("//android.widget.CheckBox[@index='1']")).click();
		
		//Long press to read Term & Condition from Pop-up 
		WebElement terms=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(terms);
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click(); //Perform Complete Purchase action 
		
		
		
		
	}

}
