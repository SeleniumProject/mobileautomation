package com.mobile.screens;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mobile.page.MobilePage;

public class SearchScreen extends MobilePage {

	 public SearchScreen(WebDriver driver) {
	        super(driver);
	 }

	 @AndroidFindBy(xpath = "//*[@text=concat('LET', \\\"'\\\", 'S START')]")
	 @iOSXCUITFindBy(xpath = "//*[@class='UIAStaticText']")
	 private MobileElement letsstartbtn;
	
    @AndroidFindBy(xpath = "//*[@contentDescription='UITestLocationsList']")
    @iOSXCUITFindBy(xpath = "//*[@class='UIAStaticText']")
    private MobileElement locationList;

    
    @AndroidFindBy(xpath = "//*[@contentDescription='UITestSearchButton']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
    private MobileElement searchbutton;

    @AndroidFindBy(xpath = "//*[@contentDescription='UITestSearchLocation']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
    private MobileElement searchLocation;

        
    /**
     * Lets start Button on the Launch Page.
     * Android & IOS.
     */
    public void clickLetsStartButton() {
    	click(letsstartbtn);
    	waitInSeconds(MED_WAIT);
    }
    
    /**
     * Click on List of Locations
     */
    public void clickLocationList() {
    	click(locationList);
    	waitInSeconds(MED_WAIT);
    }
    
    /**
     * Search for location , Enter location and click on Search button
     * @param location
     */
    public void searchLocation(String location) {
        type(searchLocation, location);
        click(searchbutton);
        waitInSeconds(SMALL_WAIT);
    
}
}
