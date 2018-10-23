package com.epam.yandexmail.tests;

import static com.epam.yandexmail.constants.YandexMailConstants.Authorization.*;

import org.testng.Assert;
import org.testng.annotations.*;

import javax.naming.OperationNotSupportedException;

public class LoginTest extends BaseYandexTest {

    @Test(description = "Check correct log in")
    public void logInTest() throws OperationNotSupportedException {
        Assert.assertEquals(steps.login(LOGIN, PASSWORD), LOGIN, "Login wasn't perfom corretly");
    }

}
