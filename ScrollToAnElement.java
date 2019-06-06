package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import utility.BaseTest;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.time.Duration;

public class ScrollToAnElement extends BaseTest{
	
		@Test
		public void scrollToAnElement_test() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();

		WebElement scrollToThisElement = driver.findElementByAndroidUIAutomator("new UiScrollable("
	        + "new UiSelector().scrollable(true)).scrollIntoView("                      
	        + "new UiSelector().textContains(\"WebView\"));");
	
		scrollToThisElement.click();


			
		}
	}
