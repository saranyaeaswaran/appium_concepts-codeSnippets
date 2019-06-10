package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import io.appium.java_client.android.GsmCallActions;
//import utility.BaseTest;

public class SimulateIncomingCall extends BaseTest{
	
		@Test
		public void incomingCall_test() throws InterruptedException {
			//gsmCall method is only available for emulators
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
			//To make the call
			driver.makeGsmCall("1234567890", GsmCallActions.CALL);
			Thread.sleep(10000);
			//Accept the call
			driver.makeGsmCall("1234567890", GsmCallActions.ACCEPT);
			//Continue performing actions on the app
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Date Widgets\"]"))).click();			
			Thread.sleep(10000);
			//Cut the call			
			driver.makeGsmCall("1234567890", GsmCallActions.CANCEL);
		}
	}
