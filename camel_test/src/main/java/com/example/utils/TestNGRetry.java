package com.example.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 *
 * @author
 *
 */
public class TestNGRetry implements IRetryAnalyzer {
    //public LogUtil log = new LogUtil(this.getClass());
    private int retryCount = 0;
    private int maxRetryCount=1;

    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            String message = "running retry for  '" + result.getName() + "' on class " +
                    this.getClass().getName() + " Retrying " + retryCount + " times";
            //log.info(message);
            retryCount++;
            return true;
        }
        return false;
    }
}


