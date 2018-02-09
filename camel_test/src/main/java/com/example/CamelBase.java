package com.example;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CamelBase {
    public AppiumDriver<MobileElement> driver;


    @BeforeMethod
    public void setUp() throws Exception {

        //
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps");
        File app = new File(appDir, "aspirit.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();


        //模拟器
        // capabilities.setCapability("deviceName","emulator-5554");
        //capabilities.setCapability("platformVersion","4.4.2");

        //HTC
        // capabilities.setCapability("deviceName","HC45PWW07968");
        // capabilities.setCapability("platformVersion", "4.4.2");


        //努比亚
        //capabilities.setCapability("deviceName","CB5A1SEYHW");
        //capabilities.setCapability("platformVersion", "5.1.1");

        //sony
        capabilities.setCapability("deviceName","NX508J");
        capabilities.setCapability("platformVersion", "5.1.1");

        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("noReset", "True");
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("appPackage", "com.druid.manager");
        capabilities.setCapability("appActivity", "com.druid.manager.ui.activity.LeadActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws Exception {

        driver.quit();
    }




}
