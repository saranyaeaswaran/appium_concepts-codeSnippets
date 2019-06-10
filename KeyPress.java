package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//import utility.BaseTest;

public class KeyPress extends BaseTest{
	
		@Test
		public void keyPress_test() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();

			//To hit back button
			driver.pressKey(new KeyEvent(AndroidKey.BACK));		
			
			//To hit home button
			driver.pressKey(new KeyEvent(AndroidKey.HOME));				
		}
	}
