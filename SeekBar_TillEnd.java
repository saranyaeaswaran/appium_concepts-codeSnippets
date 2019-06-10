package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

//import utility.BaseTest;
import static io.appium.java_client.touch.offset.PointOption.point;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;

public class SeekBar_TillEnd extends BaseTest{
	
		@Test
		public void seekBar_test() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
		
		WebElement scrollToThisElement = driver.findElementByAndroidUIAutomator("new UiScrollable("
		        + "new UiSelector().scrollable(true)).scrollIntoView("                      
		        + "new UiSelector().textContains(\"Seek Bar\"));");
		
			scrollToThisElement.click();
			
		WebElement seekBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/seek")));
		
		//Getting x,y positions of the seek bar
		int xCoOrdStartingPoint = seekBar.getLocation().getX();
		int yCoOrd = seekBar.getLocation().getY();
		//Width is till the end of the seek bar
		int xCoOrdEndingPoint = xCoOrdStartingPoint+seekBar.getSize().getWidth();		
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction
			.press(point(xCoOrdStartingPoint,yCoOrd))
			.waitAction(waitOptions(ofSeconds(1)))
			//Move till end of the bar with the same Y CoOrd
			.moveTo(point(xCoOrdEndingPoint-1,yCoOrd))
			.release()
			.perform();		

		}
	}
