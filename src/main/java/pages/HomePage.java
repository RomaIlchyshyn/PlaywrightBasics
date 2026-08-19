package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;

public class HomePage extends BasePage {

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
    @Step("Click on logout button")
    public void logout() {
        logoutButton.click();
    }
    @Step("Click on register button -> redirect to register page")
    public RegisterPage clickRegister() {
        registerButton.click();
        return new RegisterPage(page);
    }
    @Step("Click on login button -> redirect to login page")
    public LoginPage clickLogin() {
        loginButton.click();
        return new LoginPage(page);
    }
    @Step("Verify that logout button is visible")
    public boolean isLogoutButtonVisible() {
        return logoutButton.isVisible();
    }
    @Step("Verify that user authorized")
    public String getAuthorizedUser() {
        return email.textContent();
    }
    @Step("Search product with search query: {product}")
    public SearchResultPage searchProduct(String product) {
        searchField.fill(product);
        page.keyboard().press("Enter");
        return new SearchResultPage(page);
    }

}
