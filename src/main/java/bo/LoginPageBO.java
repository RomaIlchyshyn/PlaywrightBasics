package bo;

import com.microsoft.playwright.Page;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageBO {
    private final Page page;
    private final LoginPage loginPage;

    public LoginPageBO(Page page) {
        this.page = page;
        this.loginPage = new LoginPage(page);
    }

    public HomePage login(String email, String password) {
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
        return new HomePage(page);
    }
}

