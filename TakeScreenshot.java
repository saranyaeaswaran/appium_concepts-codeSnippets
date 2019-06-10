package allTests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

//import utility.BaseTest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot extends BaseTest{
	
		@Test
		public void seekBar_test() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
		
		String screenshotsFolder = System.getProperty("user.dir")+"\\Screenshots";
		new File(screenshotsFolder).mkdir();
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat df= new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		
		String file_name=df.format(new Date())+".jpg";
		try {
			FileUtils.copyFile(file, new File(screenshotsFolder + "/" + file_name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	}
