package com.mobile.page;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Collections;

import static java.time.temporal.ChronoUnit.SECONDS;

//@Log
public class MobilePage extends PageObject {

    public MobilePage(WebDriver driver) {
        super(driver, page -> {
            PageFactory.initElements(new AppiumFieldDecorator(driver), page);
            return true;
        });
        //setImplicitTimeout(timeOutInSec, SECONDS);
    }

    @Managed
    private WebDriver driver;

    @AndroidFindBy(id = "statusBarBackground")
    private WebElement progressBar;

    @AndroidFindBy(id = "loadingSpinner")
    private WebElement loadingSpinner;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Atom bank\"]")
    private WebElement atomTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Skip\"]")
    private WebElement skip;

    final PropertiesManager propertiesManager = PropertiesManager.get();

    private Integer timeOutInSec = Integer.valueOf(propertiesManager.getProperty("element.wait.sec"));

    protected void selectValueFromIosSpinner(String spinnerValue) {
        ((MobileElement) getMobileDriver().findElementByAccessibilityId("XCUIElementTypePickerWheel")).setId(spinnerValue);
    }

    
    /**
     * waits for the progress bar disappear
     */
    protected void waitForProgressBarNotPresent() {
        WebDriverWait wait = new WebDriverWait(getMobileDriver(), timeOutInSec);
        wait.until(driver1 -> ExpectedConditions.invisibilityOfAllElements(Collections.singletonList(progressBar)));
    }


    protected void waitForElementTobeDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getMobileDriver(), timeOutInSec);
        wait.until(driver1 -> ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementTobeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getMobileDriver(), timeOutInSec);
        wait.until(driver1 -> ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * switches to web view in android
     */
    protected void switchToWebViewAndroid() {
        getMobileDriver().context("WEBVIEW_com.inquisitum.waia");
    }

    /**
     * switches to native view in the android device
     */
    protected void switchToNativeViewAndroid() {
        getMobileDriver().context("NATIVE_APP");
    }


    /**
     * performs tap action on the element
     *
     * @param element WebElement
     */
    protected void tap(WebElement element) {
        GestureFactory.gestures().tap(getMobileDriver(), element);
    }

    /**
     * performs double tap action
     *
     * @param element WebElement
     */
    protected void doubleTap(WebElement element) {
        GestureFactory.gestures().doubleTap(getMobileDriver(), element);
    }

    protected void swipeRight(WebElement element) {
        GestureFactory.gestures().swipeRight(getMobileDriver(), element);
    }

    protected void swipeLeft(WebElement element) {
        GestureFactory.gestures().swipeLeft(getMobileDriver(), element);
    }

    protected void swipeUp(WebElement element) {
        GestureFactory.gestures().swipeUp(getMobileDriver(), element);
    }

    protected void swipeDown(WebElement element){
        GestureFactory.gestures().swipeDown(getMobileDriver(), element);
    }

    /**
     * clicks Paste Option From Ballon
     *
     * @param element
     */
    public void clickPasteFromBallon(WebElement element) {
        pressAndRelease(element);
    }

    protected void pressAndRelease(WebElement element) {
        GestureFactory.gestures().pressAndRelease(getMobileDriver(), element);
    }

    /**
     * returns the MobileDriver object
     *
     * @return MobileDriver
     */
    protected MobileDriver getMobileDriver() {
        return (MobileDriver) ThucydidesWebDriverSupport.getDriver();
    }

   

    public boolean isAndroidPlatform() {
        return propertiesManager.getProperty("appium.platformName").equalsIgnoreCase("android");
    }

}
