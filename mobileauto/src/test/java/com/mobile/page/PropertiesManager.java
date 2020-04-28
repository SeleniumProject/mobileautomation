package com.mobile.page;

import org.apache.commons.io.FileUtils;
import org.testng.SkipException;

import java.io.File;
import java.util.Properties;

public class PropertiesManager {

    private static PropertiesManager propertiesManager;
    private Properties properties;

    private PropertiesManager() {
        fileProcessor();
    }

    private void fileProcessor() {
        String path = System.getProperty("user.dir") + "/src/main/resources";
        File directory = new File(path);
        File[] files = directory.listFiles();
        properties = new Properties();
        for(File file: files) {
            if(file.getName().endsWith(".properties")) {
                try {
                    properties.load(FileUtils.openInputStream(file));
                } catch (Exception e) {
                    throw new SkipException(e.getMessage());
                }
            }
        }
        properties.putAll(System.getProperties());
        System.setProperties(properties);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static PropertiesManager get() {
        if(propertiesManager == null) {
            propertiesManager = new PropertiesManager();
        }
        return propertiesManager;
    }
}
