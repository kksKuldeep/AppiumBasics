package AppiumBasics;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class MobileBrowserTest extends MobileBrowserBaseClass {
	
	@Test
	public void browserTest()
	{
		//driver.findElement(AppiumBy.id("com.android.quicksearchbox:id/search_widget_text")).click();
		driver.get("https://yahoo.com");
	}

}
