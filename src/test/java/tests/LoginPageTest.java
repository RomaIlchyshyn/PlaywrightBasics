package tests;

import base.BaseTest;
import helpers.RegisterUser;
import models.TestUser;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static constants.ConstantsStorage.INVALID_PASSWORD;
import static constants.ConstantsStorage.UNREGISTERED_EMAIL;

public class LoginPageTest extends BaseTest {

    @Test(description = "Verify successful login")
    public void verifySuccessfulLogin() {
        RegisterUser registerUser = new RegisterUser(page);
        registerPageBO.clickRegister();
        TestUser user = registerUser.registerNewUser(registerPageBO);
        homePage.logout();
        loginPage = homePage.clickLogin();
        HomePage authorizedHomePage = loginPageBO.login(user.getEmail(), user.getPassword());
        assertThat(authorizedHomePage.isLogoutButtonVisible()).isTrue();
        assertThat(authorizedHomePage.getAuthorizedUser()).isEqualTo(user.getEmail());
    }

    @Test
    public void verifyLoginWithInvalidCredentials() {
        loginPage = homePage.clickLogin();
        loginPageBO.login(UNREGISTERED_EMAIL, INVALID_PASSWORD);
        assertThat(loginPage.errorMessageDisplayed()).isTrue();
        assertThat(homePage.isLogoutButtonVisible()).isFalse();

    }
}
