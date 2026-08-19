package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage{

    private final Locator searchField;
    private final Locator registerButton;
    private final Locator loginButton;
    private final Locator logoutButton;
    private final Locator email;

    public HomePage(Page page) {
        super(page);
        searchField = page.locator("#small-searchterms");
        registerButton = page.locator(".ico-register");
        loginButton = page.locator(".ico-login");
        logoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log out"));
        email = page.locator("a.account").first();
    }

    public void logout() {
        logoutButton.click();
    }
    public RegisterPage clickRegister() {
        registerButton.click();
        return new RegisterPage(page);
    }
    public LoginPage clickLogin() {
        loginButton.click();
        return new LoginPage(page);
    }
    public boolean isLogoutButtonVisible() {
        return logoutButton.isVisible();
    }
    public String getAuthorizedUser() {
        return email.textContent();
    }
    public SearchResultPage searchProduct(String product) {
        searchField.fill(product);
        page.keyboard().press("Enter");
        return new SearchResultPage(page);
    }

}
