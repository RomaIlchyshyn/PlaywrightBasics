package bo;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import models.TestUser;
import pages.HomePage;
import pages.RegisterPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RegisterPageBO {
    private final Page page;
    private final RegisterPage registerPage;
    private final HomePage homePage;

    public RegisterPageBO(Page page) {
        this.page = page;
        this.registerPage = new RegisterPage(page);
        this.homePage = new HomePage(page);
    }
    @Step("Click on register button and redirect to register page")
    public void clickRegister() {
        homePage.clickRegister();
    }
    @Step("Registration of new user")
    public RegisterPageBO registerUser(TestUser user) {
        registerPage.clickGender();
        registerPage.fillFirstName(user.getFirstName());
        registerPage.fillLastName(user.getLastName());
        registerPage.fillEmail(user.getEmail());
        registerPage.fillPassword(user.getPassword());
        registerPage.fillConfirmPassword(user.getPassword());
        registerPage.clickRegister();
        return this;
    }
    @Step("Verify successful registration message")
    public void verifyRegistrationIsSuccessful() {
        String actualMessage = registerPage.getRegistrationResult();
        assertThat(actualMessage).isEqualTo("Your registration comleted");
    }
}
