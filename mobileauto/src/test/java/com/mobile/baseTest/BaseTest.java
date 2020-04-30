package com.mobile.baseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver; 
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.logging.Level;
import java.io.File;
import java.net.MalformedURLException; 

public class BaseTest { 

   
    public static  AndroidDriver<AndroidElement> driver = null; 

    public static AppiumDriverLocalService service;
    public static AppiumServiceBuilder builder;

    public  DesiredCapabilities cap; 

    @BeforeSuite
    public void setup() {
    	cap = new DesiredCapabilities();
    	cap.setCapability("noReset", "false");
//    	builder = new AppiumServiceBuilder();
//		builder.withIPAddress("127.0.0.1");
//		builder.usingPort(4723);
//		builder.withCapabilities(cap);
//		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
//		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
//		
//		//Start the server with the builder
//		service = AppiumDriverLocalService.buildService(builder);
//		service.start();
    }
        
    @Test
    public void MobileTest() throws InterruptedException, MalformedURLException { 
    	try {
			
		
    	
    	String properties = "ios";
    	
    	if (properties.equalsIgnoreCase("android")) {
			
		
    	File appDir = new File("resources");
		File app = new File(appDir, "com.sodexo.noram.stage.com.apk");
		// To create an object of Desired Capabilities
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ce051715b078591301");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
        cap.setCapability("resetKeyboard", true);
        cap.setCapability("unicodeKeyboard", true);
        cap.setCapability("auto	ceptAlerts", true);
        cap.setCapability("autoDismissAlerts", true);
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability("skipUnlock","true");
        cap.setCapability("appPackage", "com.sodexo.noram.stage.com");
		cap.setCapability("appActivity", "md5069c4aff7a878927b23bd8de4a8ac49e.SplashActivity");
//		cap.setCapability("noReset","false");
        
			Driver.Instance =  new AndroidDriver<MobileElement>(new URL("http://127.0.0.1.4723/wd/hub"),cap);
			Thread.sleep(5000);
			Driver.Instance.context("NATIVE_APP");
			
	
    	} else {
    		//File appDir = new File("resources");
    		//File app = new File(appDir, "Bite2.iOS.ipa");
    		
    	      
    	       cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4.6");
    	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
    	        
    	        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"MyIPhone6 (12.4.6)");
    	        cap.setCapability("udid","e51e3b723010554f54498b0655e28f014f76bbd1");
    	        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
    	       // cap.setCapability("appium-version", "1.7.2");
    	        cap.setCapability("autoAcceptAlerts",false);
    	        cap.setCapability("noReset","false");
    	       //cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    	        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
    	        cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.sodexo.noram.stage.com");
                Driver.iOSInstance = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                Thread.sleep(8000);
                Driver.iOSInstance.setLogLevel(Level.INFO);
                Driver.iOSInstance.context("NATIVE_APP");
                Thread.sleep(3000);
                Driver.iOSInstance.findElement(By.xpath("//*[@text=concat('LET', \"'\", 'S START')]")).click();
                new WebDriverWait(Driver.iOSInstance, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@contentDescription='UITestLocationsList']")));
                Driver.iOSInstance.findElement(By.xpath("//*[@contentDescription='UITestLocationsList']")).click();
                
		}
    	} catch (Exception e) {
    		
		} finally {
			
		}
 

    } 

} 