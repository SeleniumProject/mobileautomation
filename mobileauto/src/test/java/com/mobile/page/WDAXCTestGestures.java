package com.mobile.page;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;

/**
 * http://appium.io/docs/en/writing-running-appium/ios/ios-xctest-mobile-gestures/
 */
public class WDAXCTestGestures implements IGestures {

    private static WDAXCTestGestures wdaxcTestGestures;

    @Override
    public void swipeUp(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: swipe", params);
    }

    @Override
    public void swipeDown(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: swipe", params);
    }

    @Override
    public void scrollUp(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: scroll", params);
    }

    @Override
    public void scrollDown(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: scroll", params);
    }

    @Override
    public void scrollLeft(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: scroll", params);
    }

    @Override
    public void scrollRight(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "right");
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: scroll", params);
    }

    @Override
    public void tap(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("x", element.getLocation().getY());
        params.put("y", element.getLocation().getY());
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: tap", params);
    }

    @Override
    public void doubleTap(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("x", element.getLocation().getY());
        params.put("y", element.getLocation().getY());
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: doubleTap", params);
    }

    @Override
    public void pinch(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("scale", 0.5);
        params.put("velocity", 1.1);
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: pinch", params);
    }

    @Override
    public void touchAndHold(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("duration", 2.0);
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: touchAndHold", params);
    }

    @Override
    public void pressAndRelease(WebDriver driver, WebElement element) {
       // throw new NotImplementedException();
    }

    @Override
    public void twoFingerTap(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: twoFingerTap", params);
    }

    @Override
    public void dragFromToDuration(WebDriver driver, WebElement element, int fromX, int fromY, int toX, int toY) {
        Map<String, Object> params = new HashMap<>();
        params.put("duration", 1.0);
        params.put("fromX", fromX);
        params.put("fromY", fromY);
        params.put("toX", toX);
        params.put("toY", toY);
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: dragFromToForDuration", params);
    }

    @Override
    public void acceptAlert(WebDriver driver, WebElement element) {
        Map<String, String> map = new HashMap<>();
        map.put("action", "accept");
        getJsExecutor(driver).executeScript("mobile: alert", map);
    }

    @Override
    public void dismissAlert(WebDriver driver, WebElement element) {
        Map<String, String> map = new HashMap<>();
        map.put("action", "dismiss");
        getJsExecutor(driver).executeScript("mobile: alert", map);
    }

    @Override
    public void swipeLeft(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: swipe", params);
    }

    @Override
    public void swipeRight(WebDriver driver, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "right");
        params.put("element", ((IOSElement) element.findElement(By.xpath("."))).getId());
        getJsExecutor(driver).executeScript("mobile: swipe", params);
    }

    private JavascriptExecutor getJsExecutor(WebDriver driver) {
        return  (JavascriptExecutor) driver;
    }

    static WDAXCTestGestures getInstance() {
        if (wdaxcTestGestures == null) {
            wdaxcTestGestures = new WDAXCTestGestures();
        }
        return wdaxcTestGestures;
    }
}
