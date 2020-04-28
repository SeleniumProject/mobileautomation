package com.mobile.page;


public class GestureFactory {

    private static final PropertiesManager propertiesManager = PropertiesManager.get();

    public static IGestures gestures() {
        if (isAndroidPlatform()) {
            return W3CMobileGestures.getInstance();
        } else {
            return WDAXCTestGestures.getInstance();
        }
    }

    private static boolean isAndroidPlatform() {
        return propertiesManager.getProperty("appium.platformName").equalsIgnoreCase("android");
    }
}
