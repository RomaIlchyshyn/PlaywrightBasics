package tests;

import Constants.ConstatsStorage;
import base.BaseTest;
import helpers.RegisterUser;
import models.TestUser;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginPageTest extends BaseTest {


    @Test
    public void verifySuccessfulLogin() {
        RegisterUser registerUser = new RegisterUser(page);
        TestUser user = registerUser.registerNewUser();
        HomePage homePage = new HomePage(page);
        homePage.logout();
        LoginPage loginPage = homePage.clickOnLogin();
        loginPage.login(user.getEmail(), user.getPassword());
        assertThat(homePage.isLogoutButtonVisible()).isTrue();
        assertThat(homePage.getAuthorizedUser()).isEqualTo(user.getEmail());
    }

    @Test
    public void verifyLoginWithInvalidCredentials() {
        HomePage homePage = new HomePage(page);
        LoginPage loginPage = homePage.clickOnLogin();
        loginPage.login(ConstatsStorage.INVALID_EMAIL, ConstatsStorage.INVALID_PASSWORD);
        assertThat(loginPage.errorMessageDisplayed()).isTrue();
        assertThat(homePage.isLogoutButtonVisible()).isFalse();

    }
}
