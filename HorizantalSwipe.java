package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
//import utility.BaseTest;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class HorizantalSwipe extends BaseTest{
	
		@Test
		public void horizantalSwipe_test() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Date Widgets\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@content-desc, 'Inline')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc, '9')]"))).click(); // Please note the * here as it takes any xpath
		
		
		WebElement element15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc, '15')]")));
		WebElement element45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc, '45')]")));
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction		
			.longPress(longPressOptions().withElement(element(element15)).withDuration(ofSeconds(1)))
			.moveTo(element(element45))
			.release()
			.perform();

			
		}
	}
