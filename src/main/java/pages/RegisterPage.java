package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;


public class RegisterPage extends BasePage {
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
    @Step("Click on gender")
    public void clickGender() {
        genderRadioButton.click();
    }
    @Step("Fill user firstname : {firstname}")
    public void fillFirstName(String firstname) {
        firstNameInput.fill(firstname);
    }
    @Step("Fill user lastname: {lastname}")
    public void fillLastName(String lastname) {
        lastNameInput.fill(lastname);
    }
    @Step("Fill user email :{email}")
    public void fillEmail(String email) {
        emailInput.fill(email);
    }
    @Step("Fill user password: {password}")
    public void fillPassword(String password) {
        passwordInput.fill(password);
    }
    @Step("Fill confirm password field: {password}")
    public void fillConfirmPassword(String password) {
        confirmPasswordInput.fill(password);
    }
    @Step("Click on register button")
    public void clickRegister() {
        registerButton.click();
    }

    private boolean isRegistrationErrorVisible() {
        return registerErrorMessage.isVisible();
    }

    @Step("Click on continue button -> redirect to home page")
    public HomePage clickOnContinueButton() {
        continueButton.click();
        return new HomePage(page);
    }
    @Step("Get message about successful registration")
    public String getRegistrationResult() {
        return registrationResult.textContent().trim();
    }

}
