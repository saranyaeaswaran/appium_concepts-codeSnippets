package allTests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;

public class WebAppTesting{
	
		@Test
		public void scrollToAnElement_test() throws MalformedURLException {	
			
			//Testing of web apps using Appium is similar to Selenium with browser name set as capability
			DesiredCapabilities cap = new DesiredCapabilities();		
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LGH93030b55959"); // this is real device
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			
			//Establishing the connection to Appium Server
			AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			
			driver.get("https://www.amazon.in");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement searchBox = wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[@id=\"nav-search-keywords\"]")));
			searchBox.sendKeys("iphone");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			
			System.out.println(driver.findElementByXPath("//div[contains(@class,'mobile-results-container')]/span/span[1]").getText());
		}
	}
