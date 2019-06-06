package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utility.BaseTest;

public class Text extends BaseTest{
	
		@Test
		public void Text_test() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Text\"]"))).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Linkify\"]"))).click();
//		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[3]"))).getText());
//		TouchActions t= new TouchActions(driver);
		
		
		}
	}
