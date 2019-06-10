package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

//import utility.BaseTest;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class DragAndDrop extends BaseTest{
	
		@Test
		public void dragAndDrop_test() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]"))).click();
		
		
		WebElement circle1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/drag_dot_1")));
		WebElement circle2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/drag_dot_2")));
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction		
			.longPress(longPressOptions().withElement(element(circle1)).withDuration(ofSeconds(2)))
			.moveTo(element(circle2))
			.release()
			.perform();			
		}
	}
