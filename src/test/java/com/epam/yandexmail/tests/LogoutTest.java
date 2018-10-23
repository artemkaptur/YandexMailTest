package com.epam.yandexmail.tests;

import static com.epam.yandexmail.constants.YandexMailConstants.Authorization.*;
import static com.epam.yandexmail.constants.YandexMailConstants.ExpressionsForMatching.LOGOUT_URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;

public class LogoutTest extends BaseYandexTest {

    @Test(description = "Check correct log out")
    public void logOutTest() throws OperationNotSupportedException {
        steps.login(LOGIN, PASSWORD);
        Assert.assertTrue(steps.logout().contains(LOGOUT_URL), "Login wasn't perfom corretly");
    }

}

