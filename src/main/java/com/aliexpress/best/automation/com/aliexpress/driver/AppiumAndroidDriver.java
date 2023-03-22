package com.aliexpress.best.automation.com.aliexpress.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AppiumAndroidDriver {

    public static AppiumDriver<MobileElement> driver;

    public static AppiumAndroidDriver suNavegador(){
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName","motorola one_fusion");
            capabilities.setCapability("udid","ZE222ML8QZ");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("appPackage","com.alibaba.aliexpresshd");
            capabilities.setCapability("appActivity","com.alibaba.aliexpresshd.home.ui.MainActivity");
            capabilities.setCapability("noReset","true");
            capabilities.setCapability("platformVersion","11");

            driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new AppiumAndroidDriver();
    }

    public io.appium.java_client.AppiumDriver<MobileElement> onDriver(){
        return driver;
    }

}
