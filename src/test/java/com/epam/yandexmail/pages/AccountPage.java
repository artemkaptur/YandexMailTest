package com.epam.yandexmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.OperationNotSupportedException;

import static com.epam.yandexmail.constants.YandexMailConstants.Url.LOGIN_PAGE_BASE_URL;

public class AccountPage extends AbstractPage {

    private WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//div[@class='personal-info-login personal-info-login__displaylogin']")
    private WebElement loginText;

    @FindBy(xpath = "//span[@data-lego='react' and @class='user-account__name user-account__name_hasAccentLetter']")
    private WebElement optionsButton;

    @FindBy(xpath = "//ul[@role='group' and @class='menu__group']/li[2]/a")
    private WebElement logoutButton;

    @FindBy(xpath = "//ul[@role='group' and @class='menu__group']/li[1]/a")
    private WebElement goToMailButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div" +
                "[@class='personal-info-login personal-info-login__displaylogin']")));
        highlightElement(loginText);
        return loginText.getText();
    }

    public void clickOnOptionsButton() {
        highlightElement(optionsButton);
        optionsButton.click();
    }

    public void clickOnLogoutButton() {
        highlightElement(logoutButton);
        logoutButton.click();
    }

    public void clickOnGoToMailButton() {
        highlightElement(goToMailButton);
        goToMailButton.click();
    }

    @Override
    public void openPage() throws OperationNotSupportedException {
        driver.navigate().to(LOGIN_PAGE_BASE_URL);
    }
}
