package com.epam.yandexmail.pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import javax.naming.OperationNotSupportedException;
import java.io.File;

public abstract class AbstractPage {
    protected WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public abstract void openPage() throws OperationNotSupportedException;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void highlightElement(WebElement element) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "green" + "'", element);
        makeScreenshot();
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    private void makeScreenshot() {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyToDirectory(screenshot, new File(".//target/screenshots/"));
            Reporter.log("<img src=\"" + screenshot.getAbsolutePath() + "\"/>");
            logger.info("Screenshot is made");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}


