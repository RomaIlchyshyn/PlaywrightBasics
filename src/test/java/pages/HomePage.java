package pages;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage{

    private final Locator searchField;
    private final Locator registerButton;
    private final Locator loginButton;
    private final Locator shoppingCardButton;
    private final Locator wishlistButton;
    private final Locator searchButton;
    private final Locator logoutButton;
    private final Locator email;

    public HomePage(Page page) {
        super(page);
        searchField = page.locator(".search-box-text.ui-autocomplete-input");
        registerButton = page.locator(".ico-register");
        loginButton = page.locator(".ico-login");
        shoppingCardButton = page.locator(".cart-label");
        wishlistButton = page.locator(".cart-label");
        searchButton = page.locator(".button-1 search-box-button");
        logoutButton = page.locator(".ico-logout");
        email = page.getByRole(AriaRole.LINK);
    }

    public void logout() {
        logoutButton.click();
    }
    public RegisterPage clickRegister() {
        registerButton.click();
        return new RegisterPage(page);
    }
    public LoginPage clickOnLogin() {
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
