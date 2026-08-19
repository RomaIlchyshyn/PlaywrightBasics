package tests;

import base.BaseTest;
import helpers.RegisterUser;
import org.testng.annotations.Test;


public class RegisterUserTest extends BaseTest {

    @Test
    public void verifySuccessfulRegistration() {
        RegisterUser registerUser = new RegisterUser(page);
        homePage.clickRegister();
        registerUser.registerNewUser(registerPageBO);
        registerPageBO.verifyRegistrationIsSuccessful();
    }
}
