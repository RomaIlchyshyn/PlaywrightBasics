package tests;

import сonstants.ConstantsStorage;
import base.BaseTest;
import helpers.RegisterUser;
import models.TestUser;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginPageTest extends BaseTest {


    @Test
    public void verifySuccessfulLogin() {
        RegisterUser registerUser = new RegisterUser(page);
        TestUser user = registerUser.registerNewUser();
        HomePage homePage = new HomePage(page);
        homePage.logout();
        LoginPage loginPage = homePage.clickLogin();
        HomePage authorizedHomePage =
                loginPage.login(user.getEmail(), user.getPassword());
        assertThat(authorizedHomePage.isLogoutButtonVisible()).isTrue();
        assertThat(authorizedHomePage.getAuthorizedUser())
                .isEqualTo(user.getEmail());
    }

    @Test
    public void verifyLoginWithInvalidCredentials() {
        HomePage homePage = new HomePage(page);
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login(ConstantsStorage.UNREGISTERED_EMAIL, ConstantsStorage.INVALID_PASSWORD);
        assertThat(loginPage.errorMessageDisplayed()).isTrue();
        assertThat(homePage.isLogoutButtonVisible()).isFalse();

    }
}
