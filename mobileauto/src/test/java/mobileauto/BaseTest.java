package mobileauto;

//package <set your test package>; 

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver; 

import io.appium.java_client.android.AndroidElement; 

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.By; 
import java.net.URL;
import java.io.File;
import java.net.MalformedURLException; 

public class BaseTest { 

   
    public static  AndroidDriver<AndroidElement> driver = null; 

  

    public static DesiredCapabilities dc = new DesiredCapabilities(); 

        
    @Test
    public void MobileTest() throws InterruptedException { 

    	File appDir = new File("resources");
		File app = new File(appDir, "API Demos for Android_v1.9.0_apkpure.com.apk");
		// To create an object of Desired Capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
        cap.setCapability("resetKeyboard", true);
        cap.setCapability("unicodeKeyboard", true);
        cap.setCapability("auto	ceptAlerts", true);
        cap.setCapability("autoDismissAlerts", true);
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability("skipUnlock","true");
        cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
		cap.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
//		cap.setCapability("noReset","false");
        try {
			Driver.Instance =  new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			Thread.sleep(5000);
			Driver.Instance.context("NATIVE_APP");


			Driver.Instance.findElement(By.xpath("//*[@text='API Demos']")).click(); 

			Driver.Instance.findElement(By.xpath("//*[@text='Animation']")).click(); 

			Driver.Instance.findElement(By.xpath("//*[@text='Events']")).click(); 

			Driver.Instance.findElement(By.xpath("//*[@text='PLAY']")).click(); 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      




        driver.quit(); 

    } 

} 