package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage extends BasePage{
    private final Locator genderRadioButton;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator registerButton;
    private final Locator registerErrorMessage;
    public final Locator registrationResult;
    public final Locator continueButton;

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
    public void clickOnGender() {
        genderRadioButton.click();
    }
    public void inputFirstName(String firstname) {
        firstNameInput.fill(firstname);
    }
    public void inputLastName(String lastname) {
        lastNameInput.fill(lastname);
    }
    public void inputEmail(String email) {
        emailInput.fill(email);
    }
    public void inputPassword(String password) {
        passwordInput.fill(password);
    }
    public void inputConfirmButton(String password) {
        confirmPasswordInput.fill(password);
    }
    public void clickOnRegisterButton() {
        registerButton.click();
    }
    public boolean errorAppear() {
        return registerErrorMessage.isVisible();
    }
    public void registerUser(String firstname, String lastname, String email, String password){
        clickOnGender();
        inputFirstName(firstname);
        inputLastName(lastname);
        inputEmail(email);
        inputPassword(password);
        inputConfirmButton(password);
        clickOnRegisterButton();
    }
    public HomePage clickOnContinueButton() {
        continueButton.click();
        return new HomePage(page);
    }
    public String getRegistrationResult() {
        return registrationResult.textContent();
    }

}
