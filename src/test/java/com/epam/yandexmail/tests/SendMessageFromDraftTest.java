package com.epam.yandexmail.tests;

import static com.epam.yandexmail.constants.YandexMailConstants.Authorization.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;

public class SendMessageFromDraftTest extends BaseYandexTest {

    @Test(groups = "fromDraft", description = "Check correct sending message from draft")
    public void sendMessageFromDraftTest() throws OperationNotSupportedException {
        steps.login(LOGIN, PASSWORD);
        Assert.assertTrue(steps.sendMessFromDraftAndCheckIt(steps.getPreveousCountOfMessages(steps.goToMailMainPage())), "Message wasn't sent from draft directory");
        steps.logout();
    }

}

