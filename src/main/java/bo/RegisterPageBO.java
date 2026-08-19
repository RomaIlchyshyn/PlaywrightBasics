package bo;

import com.microsoft.playwright.Page;
import models.TestUser;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterPageBO {
    private final Page page;
    private final RegisterPage registerPage;
    private final HomePage homePage;

    public RegisterPageBO(Page page) {
        this.page = page;
        this.registerPage = new RegisterPage(page);
        this.homePage = new HomePage(page);
    }
    public void clickRegister() {
        homePage.clickRegister();
    }
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
}
