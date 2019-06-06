package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import utility.BaseTest;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebAppTesting{
	
		@Test
		public void scrollToAnElement_test() {	
			
			//Testing of web apps using Appium is similar to Selenium with browser name set as capability
			DesiredCapabilities cap = new DesiredCapabilities();		
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LGH93030b55959"); // this is real device
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			
			//Establishing the connection to Appium Server
			AndroidDriver<AndroidElement> driver = null;
			try {
				driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.get("https://www.amazon.in");
			System.out.println(driver.getTitle());
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement searchBox = wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[@id=\"nav-search-keywords\"]")));
			searchBox.sendKeys("iphone");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			
			System.out.println(driver.findElementByXPath("//div[contains(@class,'mobile-results-container')]/span/span[1]").getText());
		}
	}
