package tests;

import base.BaseTest;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterUserTest extends BaseTest {

    @Test
    public void verifySuccessfulRegistration() {
        HomePage homePage = new HomePage(page);
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.registerUser("Test", "test", "test4123524752444@test.com","123123");
        assertThat(registerPage.getRegistrationResult()).contains("Your registration completed");
        registerPage.clickOnContinueButton();
        assertThat(homePage.isLogoutButtonVisible()).isTrue();
    }
}
