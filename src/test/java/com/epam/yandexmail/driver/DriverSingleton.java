package com.epam.yandexmail.driver;

import static com.epam.yandexmail.constants.YandexMailConstants.Driver.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    private DriverSingleton() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROMDRIVER_EXE_PATH);

            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            logger.info("Browser started");
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
        logger.info("Browser closed");
    }
}