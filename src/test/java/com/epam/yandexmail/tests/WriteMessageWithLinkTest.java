package com.epam.yandexmail.tests;


import static com.epam.yandexmail.constants.YandexMailConstants.Authorization.*;
import static com.epam.yandexmail.constants.YandexMailConstants.WritingMessage.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;

public class WriteMessageWithLinkTest extends BaseYandexTest {

    @Test(groups = "actionsPractice", description = "Check correct sending message with link")
    public void writeMessWithLinkTest() throws OperationNotSupportedException {
        steps.login(LOGIN, PASSWORD);
        Assert.assertTrue(steps.writeMessWithLinkAndCheckIt(steps.goToMailMainPage(), RECEIVER, SUBJECT, LINK, LINK_MESSAGE));
    }

}
