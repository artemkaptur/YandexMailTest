package com.epam.yandexmail.pages;

import static com.epam.yandexmail.constants.YandexMailConstants.ExpressionsForMatching.DRAFT_DIRECTORY_TITLE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class MailMainPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='mail-ComposeButton-Text']")
    private WebElement newMessageButton;

    @FindBy(name = "to")
    private WebElement toField;

    @FindBy(xpath = "//div[contains(text(),'Тема')]/following-sibling::div[1]/input")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@tabindex='10' and @role='textbox']")
    private WebElement messageField;

    @FindBy(xpath = "//div[@title = 'Закрыть']")
    private WebElement closeMessageButton;

    @FindBy(xpath = "//span[contains(text(),'Сохранить и перейти')]")
    private WebElement saveMessageToDraftButton;

    @FindBy(xpath = "//span[contains(text(),'Черновики')]")
    private WebElement goToDraftButton;

    @FindBy(xpath = "//div[@class = 'mail-MessageSnippet-Content']/span[2]")
    private WebElement lastDraftMessage;

    @FindBy(xpath = "//span[contains(text(),'Отправить')]")
    private WebElement sendFromDraftButton;

    @FindBy(xpath = "//span[contains(text(),'Отправленные')]")
    private WebElement goToSentMessagesButton;

    @FindBy(xpath = "//span[@class=' mail-MessageSnippet-Item mail-MessageSnippet-Item_threadExpand" +
            " toggles-Arrow-on-not-folded js-thread-toggle mail-MessageSnippet-Item_threadExpand_firstline is-folded']")
    private WebElement countOfSentMessages;

    @FindBy(xpath = "//span[@class='_nb-input-content']")
    private WebElement linkAddressInput;

    @FindBy(xpath = "//input[@class='nb-input _nb-simple-input _init js-text']")
    private WebElement linkTextInput;

    @FindBy(id = "cke_19")
    private WebElement insertLinkButton;

    @FindBy(xpath = "//button[@class=' nb-button _nb-action-button nb-with-s-right-gap js-update']")
    private WebElement insertLinkSubmit;

    @FindBy(xpath = "//a[@href='https://github.com/artemkaptur']")
    private WebElement attachedLink;

    private WebDriverWait wait = new WebDriverWait(driver, 10);

    public MailMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNewMessageButton() {
        highlightElement(newMessageButton);
        newMessageButton.click();
    }

    public void fillReceiver(String receiver) {
        highlightElement(toField);
        toField.sendKeys(receiver);
    }

    public void fillSubj(String subj) {
        highlightElement(subjectField);
        subjectField.sendKeys(subj);
    }

    public void fillMsg(String mess) {
        highlightElement(messageField);
        messageField.sendKeys(mess);
    }

    public void closeMessage() {
        highlightElement(closeMessageButton);
        closeMessageButton.click();
        highlightElement(saveMessageToDraftButton);
        saveMessageToDraftButton.click();
    }

    public void goToDraft() {
        highlightElement(goToDraftButton);
        goToDraftButton.click();
    }

    public void openLastDraftMessage() {
        if (driver.getTitle().equals(DRAFT_DIRECTORY_TITLE)) {
            highlightElement(lastDraftMessage);
            lastDraftMessage.click();
        } else {
            openLastDraftMessage();
        }
    }

    public boolean verifyData(String rec, String subj, String mess) {
        return (toField.getText().contains(rec) && subjectField.getAttribute("value").contains(subj) && messageField.getText().contains(mess));
    }

    public void sendMessageFromDraft() {
        sendFromDraftButton.click();
    }

    public int getCountOfDraftMessages() {
        List<WebElement> draftMessages = driver.findElements(By.xpath("//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_body js-message-snippet-body']"));
        return draftMessages.size();
    }

    public int getCountOfSentMessages() {
        return Integer.parseInt(countOfSentMessages.getText());
    }

    public void goToSentMessDirectory() {
        highlightElement(goToSentMessagesButton);
        goToSentMessagesButton.click();
    }

    public void insertLink() {
        highlightElement(insertLinkButton);
        insertLinkButton.click();
    }

    public void fillLinkAndTextLink(String link, String linkText) {
        new Actions(driver).sendKeys(linkAddressInput, link).sendKeys(linkTextInput, linkText).click(insertLinkSubmit).build().perform();
    }

    public void openAttachedLink() {
        Actions actions = new Actions(driver);
        actions.contextClick(attachedLink).sendKeys(attachedLink, Keys.ARROW_DOWN).sendKeys(attachedLink, Keys.ENTER).build().perform();
    }

    @Override
    public void openPage() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}


