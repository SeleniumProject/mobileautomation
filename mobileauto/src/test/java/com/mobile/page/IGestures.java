package com.mobile.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface IGestures {

    void swipeUp(WebDriver driver, WebElement element);

    void swipeLeft(WebDriver driver, WebElement element);

    void swipeRight(WebDriver driver, WebElement element);

    void swipeDown(WebDriver driver, WebElement element);

    void scrollUp(WebDriver driver, WebElement element);

    void scrollDown(WebDriver driver, WebElement element);

    void scrollLeft(WebDriver driver, WebElement element);

    void scrollRight(WebDriver driver, WebElement element);

    void tap(WebDriver driver, WebElement element);

    void doubleTap(WebDriver driver, WebElement element);

    void pinch(WebDriver driver, WebElement element);

    void touchAndHold(WebDriver driver, WebElement element);

    void pressAndRelease(WebDriver driver, WebElement element);

    void twoFingerTap(WebDriver driver, WebElement element);

    void dragFromToDuration(WebDriver driver, WebElement element, int fromX, int fromY, int toX, int toY);

    void acceptAlert(WebDriver driver, WebElement element);

    void dismissAlert(WebDriver driver, WebElement element);

}
