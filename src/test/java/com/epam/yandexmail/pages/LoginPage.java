package com.epam.yandexmail.pages;

import static com.epam.yandexmail.constants.YandexMailConstants.Url.LOGIN_PAGE_BASE_URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.naming.OperationNotSupportedException;

public class LoginPage extends AbstractPage {

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "passwd")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit' and @class='passport-Button']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginAndPassw(String login, String passw) {
        highlightElement(loginField);
        loginField.sendKeys(login);
        highlightElement(passwordField);
        passwordField.sendKeys(passw);
    }

    public AccountPage clickOnSubmitButton() {
        highlightElement(submitButton);
        submitButton.click();
        return new AccountPage(driver);
    }

    @Override
    public void openPage() throws OperationNotSupportedException {
        driver.navigate().to(LOGIN_PAGE_BASE_URL);
    }
}


