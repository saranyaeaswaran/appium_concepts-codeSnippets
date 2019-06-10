package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
//import utility.BaseTest;

public class SimulateIncomingSMS extends BaseTest{
	
		@Test
		public void incomingSMS_test() throws InterruptedException {
			//sms method is only available for emulators
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
			driver.sendSMS("555-555-5555", "Your code is 654321");
			Thread.sleep(10000);
		}
	}
