package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator loginErrorMessage;

    public LoginPage(Page page) {
        super(page);
        emailInput = page.locator("#Email");
        passwordInput = page.locator("#Password");
        loginButton = page.locator(".login-button");
        loginErrorMessage = page.locator(".validation-summary-errors");
    }
    @Step("Fill email: {email}")
    public void fillEmail(String email) {
        emailInput.fill(email);
    }
    @Step("Fill password: {password}")
    public void fillPassword(String password) {
        passwordInput.fill(password);
    }
    @Step("Click on login button")
    public void clickLogin() {
        loginButton.click();
    }
    @Step("Verify that error message is displayed")
    public boolean errorMessageDisplayed() {
        return loginErrorMessage.isVisible();
    }
}
