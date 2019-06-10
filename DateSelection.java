package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
//import utility.BaseTest;

public class DateSelection extends BaseTest{
	
		@Test
		public void gesture_test() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Date Widgets\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@content-desc, 'Dialog')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@content-desc, 'change the date')]"))).click();
			
		}
	}
