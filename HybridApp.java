package allTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HybridApp {
	
		@Test
		public void hybridApp_test() throws MalformedURLException, InterruptedException {	
			
			//Testing of web apps using Appium is similar to Selenium with browser name set as capability
			DesiredCapabilities cap = new DesiredCapabilities();		
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LGH93030b55959"); // this is real device
			cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\apps\\TheApp-v1.5.0.apk");
			//Establishing the connection to Appium Server
			AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4724/wd/hub"), cap);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Webview Demo\"]/android.widget.TextView[1]"))).click();
			
			MobileElement url = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("urlInput")));
			MobileElement goButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("navigateBtn")));
			url.sendKeys("https://appiumpro.com");
			goButton.click();
			Thread.sleep(2000);  
			//To switch to web view
			driver.context("WEB_VIEW");

		}
	}
