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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClassIOS {

	public IOSDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigurationAppiumIOS() throws MalformedURLException {
		System.out.println("Hello iOS");
		// start Appium Server automatically/programatically
		 service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).build();

		service.start();


		XCUITestOptions options=new XCUITestOptions();
		options.setDeviceName("iPhone 12 Pro");
		options.setCapability("platformName", "iOS");
		options.setApp("/Users/c100-189/Desktop/UIKitCatalog.app");
		
		options.setPlatformVersion("14.5");
		//Appium Install webdriver agent in Apple device
		options.setWdaLaunchTimeout(Duration.ofSeconds(10));
		driver = new IOSDriver(new URL("http://0.0.0.0:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterClass
	public void StopService() {

		driver.quit();
		service.stop();
	}
	
	}
