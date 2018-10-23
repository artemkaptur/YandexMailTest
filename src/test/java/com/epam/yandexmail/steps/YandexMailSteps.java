package com.epam.yandexmail.steps;

import com.epam.yandexmail.driver.DriverSingleton;
import com.epam.yandexmail.pages.AccountPage;
import com.epam.yandexmail.pages.LoginPage;
import com.epam.yandexmail.pages.MailMainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class YandexMailSteps {
    private WebDriver driver;

    private static Logger logger = LogManager.getLogger();

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

    public String login(String log, String passw) throws OperationNotSupportedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.fillLoginAndPassw(log, passw);
        AccountPage accauntPage = loginPage.clickOnSubmitButton();
        logger.info("Login performed");
        return accauntPage.getLoginText();
    }

    public String logout() throws OperationNotSupportedException {
        AccountPage accauntPage = new AccountPage(driver);
        accauntPage.openPage();
        accauntPage.clickOnOptionsButton();
        accauntPage.clickOnLogoutButton();
        logger.info("Logout performed");
        return driver.getCurrentUrl();
    }

    public MailMainPage goToMailMainPage() {
        AccountPage accauntPage = new AccountPage(driver);
        accauntPage.clickOnOptionsButton();
        accauntPage.clickOnGoToMailButton();
        logger.info("Go to MailMainPage");
        return new MailMainPage(driver);
    }

    public void writeNewLetter(MailMainPage mailMainPage, String receiver, String subj, String msg) {
        mailMainPage.clickOnNewMessageButton();
        mailMainPage.fillReceiver(receiver);
        mailMainPage.fillSubj(subj);
        mailMainPage.fillMsg(msg);
        logger.info("Receiver, subject and message fields are filled");
    }

    public boolean writeMessWithLinkAndCheckIt(MailMainPage mailMainPage, String receiver, String subj, String link, String linkText) {
        mailMainPage.clickOnNewMessageButton();
        mailMainPage.fillReceiver(receiver);
        mailMainPage.fillSubj(subj);
        mailMainPage.insertLink();
        mailMainPage.fillLinkAndTextLink(link, linkText);
        logger.info("Receiver, subject and link are filled");
        return checkCorrectLinkWritten(mailMainPage, link);
    }

    private boolean checkCorrectLinkWritten(MailMainPage mailMainPage, String linkUrl) {
        mailMainPage.openAttachedLink();
        switchWindow();
        logger.info("Window is switched");
        return driver.getCurrentUrl().equals(linkUrl);
    }

    private void switchWindow() {
        String currentWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equalsIgnoreCase(currentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public MailMainPage goToDraftAndOpenLastMess() {
        MailMainPage mailMainPage = new MailMainPage(driver);
        mailMainPage.goToDraft();
        logger.info("Draft directory is opened");
        mailMainPage.openLastDraftMessage();
        logger.info("Last draft message is opened");
        return mailMainPage;
    }

    public boolean checkSendingMessToDraft(String receiver, String subject, String message) {
        MailMainPage mailMainPage = new MailMainPage(driver);
        mailMainPage.closeMessage();
        goToDraftAndOpenLastMess();
        logger.info("Verifying data in last draft message is started");
        return mailMainPage.verifyData(receiver, subject, message);
    }

    public List<Integer> getPreveousCountOfMessages(MailMainPage mailMainPage) {
        List<Integer> prevCountOfMessages = new ArrayList<>();
        mailMainPage.goToDraft();
        driver.navigate().refresh();
        prevCountOfMessages.add(mailMainPage.getCountOfDraftMessages());
        logger.info("Preveous draft messages count - " + prevCountOfMessages.get(0));
        mailMainPage.goToSentMessDirectory();
        driver.navigate().refresh();
        prevCountOfMessages.add(mailMainPage.getCountOfSentMessages());
        logger.info("Preveous sent messages count - " + prevCountOfMessages.get(1));
        return prevCountOfMessages;
    }

    public boolean sendMessFromDraftAndCheckIt(List<Integer> prevCountOfMessages) {
        MailMainPage mailMainPage = new MailMainPage(driver);
        goToDraftAndOpenLastMess();
        mailMainPage.sendMessageFromDraft();
        mailMainPage.goToDraft();
        driver.navigate().refresh();
        int currDraft = mailMainPage.getCountOfDraftMessages();
        logger.info("Current draft messages count - " + currDraft);
        boolean firstProof = prevCountOfMessages.get(0) - currDraft == 1;
        mailMainPage.goToSentMessDirectory();
        driver.navigate().refresh();
        int currSent = mailMainPage.getCountOfSentMessages();
        logger.info("Current sent messages count - " + currSent);
        boolean secondProof = prevCountOfMessages.get(1) == currSent;
        return firstProof == true && secondProof == true;
    }

}
