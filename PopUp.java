package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

//import utility.BaseTest;

public class PopUp extends BaseTest{
	
		@Test
		public void popUp_test() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
				
		WebElement scrollToThisElement = driver.findElementByAndroidUIAutomator("new UiScrollable("
		        + "new UiSelector().scrollable(true)).scrollIntoView("                      
		        + "new UiSelector().textContains(\"Popup Menu\"));");
		
			scrollToThisElement.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@content-desc,'Make a Popup')]"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Add']"))).click();
		}
	}
