package helpers;

import bo.RegisterPageBO;
import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import models.TestUser;


public class RegisterUser {
    private final Page page;
    private final Faker faker = new Faker();

    public RegisterUser(Page page) {
        this.page = page;
    }

    @Step("New test user registration")
    public TestUser registerNewUser(RegisterPageBO registerPageBO) {

        TestUser user = createUser();
        registerPageBO.registerUser(user);
        return user;

    }
    @Step("Creating of new user")
    public TestUser createUser() {

        return new TestUser(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), faker.internet().password());
    }
}
