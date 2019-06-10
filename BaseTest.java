package allTests;


import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public abstract class BaseTest {
	
	
	public static AndroidDriver<AndroidElement> driver;
	public static WebDriverWait wait;

	@BeforeSuite
	public void initilizeDriver() throws NoSuchFieldException {
		
			DesiredCapabilities cap = new DesiredCapabilities();		
			//To which emulator we need to connect
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_2_API_25"); // This is emulator
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LGH93030b55959"); // this is real device
			
			//The app that needs to be opened in the emulator
//			cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\apps\\ApiDemos-debug.apk");
			cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\src\\test\\java\\allTests\\ApiDemos-debug.apk");
			cap.setCapability("skipUnlock","true");
			
			//Establishing the connection to Appium Server which will take this code to the emulator to simulate
			try {
				driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wait = new WebDriverWait(driver, 10);

		}

	/*****************************************************************************************************************/
	@AfterSuite
	public void quitDrivers() {
//		driver.quit();

	}
	/************************************************************************************************************************/
	/*
	 * method.getName() returns the name of the current test method during run time.
	 * */
	@BeforeMethod
	public void beforeMethod(Method method) {
		

	}
	
	/****************************************************************************************************************/
	
	@AfterMethod
	public void afterMethod(Method method) {
		

	}

	/****************************************************************************************************************/
	
	@BeforeClass
	public void beforeClass() {
		
	}

	
/****************************************************************************************************************/	
	@AfterClass
	public void closeApplication(){
		

	}

}
/*****************************************************************************************************************/