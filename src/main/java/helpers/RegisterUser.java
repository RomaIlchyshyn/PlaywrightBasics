package helpers;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import models.TestUser;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUser {
    private final Page page;
    Faker faker = new Faker();

    public RegisterUser(Page page) {
        this.page = page;
    }
    public TestUser registerNewUser() {

        TestUser user = createUser();
        HomePage homePage = new HomePage(page);
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.registerUser(user);

        return user;

    }
    public TestUser createUser() {

        return new TestUser(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.internet().password()
        );
    }
}
