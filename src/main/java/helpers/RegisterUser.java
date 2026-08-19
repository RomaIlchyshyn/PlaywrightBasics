package helpers;

import bo.RegisterPageBO;
import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import models.TestUser;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUser {
    private final Page page;
    private final Faker faker = new Faker();

    public RegisterUser(Page page) {
        this.page = page;
    }

    public TestUser registerNewUser(RegisterPageBO registerPageBO) {

        TestUser user = createUser();
        registerPageBO.registerUser(user);
        return user;

    }

    public TestUser createUser() {

        return new TestUser(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), faker.internet().password());
    }
}
