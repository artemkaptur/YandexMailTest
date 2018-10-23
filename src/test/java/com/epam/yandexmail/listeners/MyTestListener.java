package com.epam.yandexmail.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

    private static Logger logger = LogManager.getLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " - started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " - passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " - failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " - skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " - failed but within success percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
