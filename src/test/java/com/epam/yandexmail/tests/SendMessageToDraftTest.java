package com.epam.yandexmail.tests;

import static com.epam.yandexmail.constants.YandexMailConstants.Authorization.*;
import static com.epam.yandexmail.constants.YandexMailConstants.ExpressionsForMatching.RECEIVER_CHECK;
import static com.epam.yandexmail.constants.YandexMailConstants.WritingMessage.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;

public class SendMessageToDraftTest extends BaseYandexTest {

    @Test(groups = "toDraft", description = "Check correct sending message to draft")
    public void sendMessageToDraftTest() throws OperationNotSupportedException {
        steps.login(LOGIN, PASSWORD);
        steps.writeNewLetter(steps.goToMailMainPage(), RECEIVER, SUBJECT, MESSAGE);
        Assert.assertTrue(steps.checkSendingMessToDraft(RECEIVER_CHECK, SUBJECT, MESSAGE), "Message wasn't sent into draft directory");
    }

}
