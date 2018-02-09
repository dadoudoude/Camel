package com.example.utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.appium.java_client.AppiumDriver;

/**
 *
 *
 * @author
 */
public class TestNGListener extends TestListenerAdapter {

    private static AppiumDriver<?> driver;

    //LogUtil log = new LogUtil(this.getClass());

    public static void setDriver(AppiumDriver<?> driver) {
        TestNGListener.driver = driver;
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        //log.info("Test Success");
        super.onTestSuccess(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        //log.error("Test Failure");
        super.onTestFailure(tr);

      //  ScreenShot screenShot = new ScreenShot(driver);
      //  screenShot.getScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        //log.error("Test Skipped");
        super.onTestSkipped(tr);
    }

    @Override
    public void onStart(ITestContext testContext) {
        //log.info("Test Start");
        super.onStart(testContext);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        //log.info("Test Finish");
        super.onFinish(testContext);
    }




}
