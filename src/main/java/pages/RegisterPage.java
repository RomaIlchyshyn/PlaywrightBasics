package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import models.TestUser;

public class RegisterPage extends BasePage{
    private final Locator genderRadioButton;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator registerButton;
    private final Locator registerErrorMessage;
    private final Locator registrationResult;
    private final Locator continueButton;

    public RegisterPage(Page page) {
        super(page);
        genderRadioButton = page.locator("#gender-male");
        firstNameInput = page.locator("#FirstName");
        lastNameInput = page.locator("#LastName");
        emailInput = page.locator("#Email");
        passwordInput = page.locator("#Password");
        confirmPasswordInput = page.locator("#ConfirmPassword");
        registerButton = page.locator("#register-button");
        registerErrorMessage = page.locator(".validation-summary-errors");
        registrationResult = page.locator(".result");
        continueButton = page.locator(".button-1.register-continue-button");
    }
    public void clickGender() {
        genderRadioButton.click();
    }
    public void fillFirstName(String firstname) {
        firstNameInput.fill(firstname);
    }
    public void fillLastName(String lastname) {
        lastNameInput.fill(lastname);
    }
    public void fillEmail(String email) {
        emailInput.fill(email);
    }
    public void fillPassword(String password) {
        passwordInput.fill(password);
    }
    public void fillConfirmPassword(String password) {
        confirmPasswordInput.fill(password);
    }
    public void clickRegister() {
        registerButton.click();
    }
    public boolean isRegistrationErrorVisible() {
        return registerErrorMessage.isVisible();
    }
    public void registerUser(TestUser user){
        clickGender();
        fillFirstName(user.getFirstName());
        fillLastName(user.getLastName());
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        fillConfirmPassword(user.getPassword());
        clickRegister();
    }
    public HomePage clickOnContinueButton() {
        continueButton.click();
        return new HomePage(page);
    }
    public String getRegistrationResult() {
        return registrationResult.textContent();
    }

}
