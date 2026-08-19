package tests;

import base.BaseTest;
import helpers.RegisterUser;
import models.TestUser;
import org.testng.annotations.Test;
import pages.HomePage;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterUserTest extends BaseTest {

    @Test
    public void verifySuccessfulRegistration() {
        registerPage = homePage.clickRegister();
        RegisterUser registerUser = new RegisterUser(page);
        TestUser user = registerUser.createUser();
        registerPage.registerUser(user);
        assertThat(registerPage.getRegistrationResult()).contains("Your registration completed");
        HomePage authorizedHomePage = registerPage.clickOnContinueButton();
        assertThat(authorizedHomePage.isLogoutButtonVisible()).isTrue();
    }
}
