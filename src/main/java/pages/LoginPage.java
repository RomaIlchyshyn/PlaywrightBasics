package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

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

    public void fillEmail(String email) {
        emailInput.fill(email);
    }
    public void fillPassword(String password) {
        passwordInput.fill(password);
    }
    public void clickLogin() {
        loginButton.click();
    }

    public boolean errorMessageDisplayed() {
        return loginErrorMessage.isVisible();
    }
}
