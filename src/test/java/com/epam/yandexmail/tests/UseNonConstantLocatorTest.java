package com.epam.yandexmail.tests;

import static com.epam.yandexmail.constants.YandexMailConstants.ExpressionsForMatching.YANDEX_LOGO_TEXT;
import static com.epam.yandexmail.driver.DriverSingleton.getDriver;

import com.epam.yandexmail.pages.YandexSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UseNonConstantLocatorTest extends BaseYandexTest {

    @Test(description = "Check non constant locator working")
    public void useNonConstantLocatorTest() {
        YandexSearchPage yandexSearchPage = new YandexSearchPage(getDriver());
        yandexSearchPage.openPage();
        Assert.assertEquals(yandexSearchPage.getLogoText(), YANDEX_LOGO_TEXT, "There is incorrect logo text");
    }
}
