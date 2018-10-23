package com.epam.yandexmail.tests;

import com.epam.yandexmail.steps.YandexMailSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseYandexTest {

    protected YandexMailSteps steps;

    @BeforeClass(alwaysRun = true, description = "Init browser")
    public void setUp() {
        steps = new YandexMailSteps();
        steps.initBrowser();
    }

    @AfterClass(alwaysRun = true, description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
