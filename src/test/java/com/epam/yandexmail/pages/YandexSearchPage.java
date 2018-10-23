package com.epam.yandexmail.pages;

import static com.epam.yandexmail.constants.YandexMailConstants.Url.YANDEX_SEARCH_PAGE_BASE_URL;

import com.epam.yandexmail.util.DynamicElementLocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class YandexSearchPage {
    private WebDriver driver;

    private final Map<String, String> substitutions;

    @FindBy(xpath = "//div[@class='${className}']")
    private WebElement logo;

    public YandexSearchPage(WebDriver driver) {
        this.driver = driver;

        substitutions = new HashMap<>();
        substitutions.put("className", "home-logo__default");

        PageFactory.initElements(new DynamicElementLocatorFactory(driver, substitutions), this);
    }

    public String getLogoText() {
        return logo.getAttribute("aria-label");
    }

    public void openPage() {
        driver.navigate().to(YANDEX_SEARCH_PAGE_BASE_URL);
    }

}
