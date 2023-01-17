package AppiumBasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBrowserBaseClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	

	@BeforeClass
	public void ConfigurationAppium() throws MalformedURLException {
		System.out.println("Hello Mobile");
		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).
				withIPAddress("0.0.0.0").usingPort(4723).build();
		service.start();

//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("KuldeepPhone");
//		//options.setChromedriverExecutable("//Volumes//DATA1//Kuldeep_Automation//chromedriver 2");
//		
////		options.setChromedriverExecutable(System.getProperty("//Volumes//DATA1//Kuldeep_Automation//chromedriver 2"));
////			
////			options.setCapability("browserName", "Chrome");
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("KuldeepPhone");
		options.setChromedriverExecutable("//Volumes//DATA1//Kuldeep_Automation//chromedriver 2");//
		options.setCapability("browserName", "Google");
		
		
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void StopService() {

		driver.quit();
		service.stop();
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void ScrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 500, "top", 500, "width", 200, "height", 500, "direction", "up", "percent", 3.0));
		} while (canScrollMore);
	}

	public void SwipeAction(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),

						"direction", direction, "percent", 0.75));
	}

	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
}
