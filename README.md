# Android virtual device setup:
1. Download Java and paste the bin path from Program files to environment variables

2. Download Android Studio and install it, and open Android Studio from default or from **C:\Program Files\Android\Android Studio\bin\studio64.exe**

3. This will start downloading and installing the below SDK components
	1. Android Studio - **C:\Users\<username>\AppData**
	2. Android SDK **C:\Users\<username>\AppData\Local**

4. Android SDK is required to run Android emulator.
	1. Provide the path of SDK as **ANDROID_HOME** in environmental variables
	2. Provide the below in the in **'PATH'** variables
	*1. path of SDK/tools/bin*
	*2. path of SDK/tools*
	*3. path of SDK/platform_tools*

5. Android SDK runs on Java 8, so any upgraded versions are present in the system download and instal JDK8 and update the "path" variable accorindly(java -version)
	* Run `sdkmanager --list`" from command and it should not throw any class not found error
	* type `uiautomatorviewer` to check uiautomatorviewer is working properly.

6. Android Studio is required to configure Virtual device/Emulator.  Open Android Studio and click on start new android project

7. you will see the device and the android icon. Click this icon, you will open android virtual device manager. Or open this from Tools > AVD Manager. This will Open the Virtual Device Manager in separate window

8. Click on Create  a new virtual device > Select the device based on model info > Select and download the android version and click on next > Change the device name if needed

9. Now the virtual device is created	

10. If you have Docker for Windows that requires Hyper-V to be enabled. Unfortunately, AVD can’t run with Hyper-V enabled. So to disable Hyper-V, Go to Start > Turn Windows features on or off, Then, disable Hyper-V in your computer. It will ask you to restart your computer. We have to disable VTx from BIOS as well

11. While installing if any issues in Intel HAXM issues, remove it manually from Control Panel > Remove programs and download the standalone version from intel

12. To open the emulator directly from command prompt >  cd <plaform_tools folder path> C:\Users\<username>\AppData\Local\Android\Sdk\platform-tools
											>emulator -avd <deviceName>  ----- `emulator -avd pixel_2_API_25`
	
# Appium Setup:
1. Download node js and install it. Provide the node js programfiles path in Env variables (cmd > `node --version`, cmd> `npm --version`)

2. We can either download Appium server from npm node modules and start it using command 'appium' from command prompt, or

3. Go to http://appium.io/downloads.html and click “Appium-Desktop for OSX, Windows and Linux” link, click on the setup exe file and download and install it

4. When installation finished, double-click the appium icon (from Desktop 'Appium' as desktop app) and open the appium server

5. Provide the address as 0.0.0.0 and start the Appium server

6. In Eclipse, create a maven project and add libraries related to selenium-java, Appium Java client and configure the project with a test script

7. Add the sample application apk in a folder under the project folder

## To test in Emulators:
**To verify before running an Appium program:**
1. Appium (from desktop or from command prompt if downloaded from NPM) to be started and note down the port in which its started
2. Mobile Emulator (virtual device) to be started or real device with USB debugging option should have been connected
	
## Base connection for Native App:	
```java
public static void main(String[] args) throws MalformedURLException {
    DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_2_API_25");
	cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\app\\ApiDemos-debug.apk");
	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}
}
```	
## Using Appium desktop Inspector to inspect the elements to get the properties:	
1. From Appium desktop, invoke 'Start Inspector Session' (magnifying glass at right top corner)
2. Once the session is invoked, click on 'Attached to session' > Hit Refresh icon to select the current running session > select the current session from dropdown > click Attach to Session
3. This will get the screenshot of the application and from here we can inspect through the elements
	
## To test in real device :
1. Connect your real device to your laptop via USB port with USB debigging option
2. From settings > About Phone > Software Info > tab Bulid Number anout 5-7 time to enable developer options
3. From cmd > adb devices will display the connected device name
4. Or, type chrome://inspect/devices#devices in browser to view the connected devices

## Base Connection code to test Web App in mobile:
```java
public void scrollToAnElement_test() throws MalformedURLException {	
//Testing of web apps using Appium is similar to Selenium with browser name set as capability
DesiredCapabilities cap = new DesiredCapabilities();		
cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LGH93030b55959"); // this is real device
cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
//Establishing the connection to Appium Server
AndroidDriver<AndroidElement> driver = null;
driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
driver.get("https://www.amazon.in");
WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement searchBox = wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[@id=\"nav-search-keywords\"]")));
searchBox.sendKeys("iphone");
Actions action = new Actions(driver);
action.sendKeys(Keys.ENTER).build().perform();
}
```
### Using Devtools to inspect the elements in web apps:
1. Enable USB Debugging in mobile device and connect to the system
2. On your development machine, open Chrome.
3. Open DevTools
4. In DevTools, click the Main Menu Main Menu then select `More tools > Remote devices`

### Misc commands :
1. To check if the current session of the android driver is a Native App, Mobile App or Hybrid App >>> driver.getContext()
2. To get device orientation of Landscape and Portrait >>>> driver.getOrientation()
3. To check if the device is locked >> driver.isDeviceLocked()
	
## Program Snippets :
1. For long press on an element,
```java
TouchAction touchAction = new TouchAction(driver);
touchAction		
	.longPress(longPressOptions().withElement(element(longPressElement)).withDuration(ofSeconds(2)))
	.release()
    .perform();
```

2. Moving from one element to another element to mock swipe,
```java
TouchAction touchAction = new TouchAction(driver);
touchAction		
	.longPress(longPressOptions().withElement(element(element15)).withDuration(ofSeconds(1)))
	.moveTo(element(element45))
	.release()
	.perform();
```	

3. Scroll to an element and click it:
```java
WebElement scrollToThisElement = driver.findElementByAndroidUIAutomator("new UiScrollable("
		        + "new UiSelector().scrollable(true)).scrollIntoView("                      
		        + "new UiSelector().textContains(\"WebView\"));");
scrollToThisElement.click();
```

4. Drag and Drop:
```java
WebElement circle1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/drag_dot_1")));
WebElement circle2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/drag_dot_2")));
TouchAction touchAction = new TouchAction(driver);
	touchAction		
    	.longPress(longPressOptions().withElement(element(circle1)).withDuration(ofSeconds(2)))
		.moveTo(element(circle2))
		.release()
		.perform();			
	}
```		
5. Seek bar till end:
```java
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
```
6. Seek bar to a particular point:
```java
//To move a particular point, calculate the percentage from the end point to be moved
int moveToPoint = (int)(xCoOrdEndingPoint * .85);
System.out.println(moveToPoint);
touchAction
    .press(point(xCoOrdStartingPoint,yCoOrd))
    .waitAction(waitOptions(ofSeconds(1)))
	//Move till end of the bar with the same Y CoOrd
	.moveTo(point(moveToPoint,yCoOrd))
	.release()
	.perform();	
	}
```
7. Key Press events:
```java
public void keyPress_test() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
	//To hit back button
	driver.pressKey(new KeyEvent(AndroidKey.BACK));		
	//To hit home button
	driver.pressKey(new KeyEvent(AndroidKey.HOME));				
	}
```
8. To simulate incoming call:
```java
public void incomingCall_test() throws InterruptedException {
    //gsmCall method is only available for emulators
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();
	    //To make the call
		driver.makeGsmCall("1234567890", GsmCallActions.CALL);
		Thread.sleep(10000);
		//Accept the call
		driver.makeGsmCall("1234567890", GsmCallActions.ACCEPT);
		//Continue performing actions on the app
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Date Widgets\"]"))).click();		Thread.sleep(10000);
		//Cut the call			
		driver.makeGsmCall("1234567890", GsmCallActions.CANCEL);
	}
```