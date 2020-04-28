package com.mobile.page;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class W3CMobileGestures implements IGestures {

    private static W3CMobileGestures w3CMobileGestures;

    @Override
    public void swipeUp(WebDriver driver, WebElement element) {
        Point point = element.getLocation();
        getTouchAction(driver).longPress(PointOption.point(point.getX(),point.getY()))
                .moveTo(PointOption.point(100, 400))
                .release().perform();
    }

    @Override
    public void swipeLeft(WebDriver driver, WebElement element) {
        TouchAction touchActions = getTouchAction(driver);
        touchActions.press(PointOption.point(700, 700))
                .moveTo(PointOption.point(0, 700)).release().perform();
    }

    @Override
    public void swipeRight(WebDriver driver, WebElement element) {
        TouchAction touchActions = getTouchAction(driver);
        Point point = element.getLocation();
        touchActions.longPress(PointOption.point(point.getX(), point.getY()))
                .moveTo(PointOption.point(-90, point.getY()))
                .release().perform();//Fill X with valid value
    }

    @Override
    public void swipeDown(WebDriver driver, WebElement element) {
        Point point = element.getLocation();
        getTouchAction(driver).longPress(PointOption.point(100, 400))
                .moveTo(PointOption.point(point.getX(),point.getY()))
                .release().perform();
    }

    @Override
    public void scrollUp(WebDriver driver, WebElement element) {
        swipeUp(driver, element);
    }

    @Override
    public void scrollDown(WebDriver driver, WebElement element) {
        scrollDown(driver, element);
    }

    @Override
    public void scrollLeft(WebDriver driver, WebElement element) {
        swipeLeft(driver, element);
    }

    @Override
    public void scrollRight(WebDriver driver, WebElement element) {
        swipeRight(driver, element);
    }

    @Override
    public void tap(WebDriver driver, WebElement element) {
        TouchAction touchAction = getTouchAction(driver);
        Point elementLocation = element.getLocation();
        touchAction.tap(PointOption.point(elementLocation.getX(), elementLocation.getY())).perform();
    }

    @Override
    public void doubleTap(WebDriver driver, WebElement element) {
        TouchAction touchActions = getTouchAction(driver);
        Point elementLocation = element.getLocation();
        touchActions.tap(PointOption.point(elementLocation.getX(), elementLocation.getY()))
                .tap(PointOption.point(elementLocation.getX(), elementLocation.getY()))
                .perform();
    }

    @Override
    public void pinch(WebDriver driver, WebElement element) {
        //throw new NotImplementedException();
    }

    @Override
    public void touchAndHold(WebDriver driver, WebElement element) {
        TouchAction touchActions = getTouchAction(driver);
        Point elementLocation = element.getLocation();
        touchActions.longPress(LongPressOptions.longPressOptions()
                .withDuration(Duration.ofMillis(2000))
                .withPosition(PointOption.point(elementLocation.getX(), elementLocation.getY()))
            ).perform();
    }

    @Override
    public void pressAndRelease(WebDriver driver, WebElement element) {
        TouchAction touchActions = getTouchAction(driver);
        Point point = element.getLocation();
        touchActions.press(PointOption.point(point.getX(), point.getY()))
                .release().perform();
    }

    @Override
    public void twoFingerTap(WebDriver driver, WebElement element) {
        //throw new NotImplementedException();
    }

    @Override
    public void dragFromToDuration(WebDriver driver, WebElement element, int fromX, int fromY, int toX, int toY) {
       // throw new NotImplementedException();
    }

    @Override
    public void acceptAlert(WebDriver driver, WebElement element) {
       // throw new NotImplementedException();
    }

    @Override
    public void dismissAlert(WebDriver driver, WebElement element) {
       // throw new NotImplementedException();
    }

    private TouchAction getTouchAction(WebDriver driver) {
        return new TouchAction((MobileDriver)driver);
    }

    static W3CMobileGestures getInstance() {
        if (w3CMobileGestures == null) {
            w3CMobileGestures = new W3CMobileGestures();
        }
        return w3CMobileGestures;
    }
}
