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
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.openqa.selenium.remote.DesiredCapabilities;
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
    	builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		
		//Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
    }
        
    @Test
    public void MobileTest() throws InterruptedException, MalformedURLException { 
    	try {
			
		
    	
    	String properties = "android";
    	
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
    		File appDir = new File("resources");
    		File app = new File(appDir, "Bite2.iOS (1).ipa");
    		
    		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
    		cap.setCapability(MobileCapabilityType.UDID, "e51e3b723010554f54498b0655e28f014f76bbd1");
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
            cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.sodexo.noram.stage.com");
            Driver.iOSInstance = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            Driver.iOSInstance.setLogLevel(Level.INFO);
		}
    	} catch (Exception e) {
    		service.stop();
		} finally {
			service.stop();
		}
 

    } 

} 