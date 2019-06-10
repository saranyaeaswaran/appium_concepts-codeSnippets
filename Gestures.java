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

public class Gestures extends BaseTest{
	
		@Test
		public void gesture_test() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@content-desc, 'Custom Adapter')]"))).click();
		
		WebElement longPressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='People Names']")));
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction		
			.longPress(longPressOptions().withElement(element(longPressElement)).withDuration(ofSeconds(2)))
			.release()
			.perform();
		
		
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
			
		}
	}
