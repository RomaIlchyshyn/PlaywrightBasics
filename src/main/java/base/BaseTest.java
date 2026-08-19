package base;

import bo.LoginPageBO;
import bo.RegisterPageBO;
import com.microsoft.playwright.*;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import lombok.Getter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ConfigManager;
import utils.TestListener;


@Listeners({AllureTestNg.class, TestListener.class, })
public abstract class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    @Getter
    protected Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected LoginPageBO loginPageBO;
    protected RegisterPageBO registerPageBO;

    protected BaseTest() {
    }

    @BeforeClass
    @Step("Initializing playwright and browser instance")
    public void setUpBrowser() {
        playwright = Playwright.create();
        boolean headless = Boolean.parseBoolean(ConfigManager.get("headless"));
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
    }

    @BeforeMethod
    @Step("Initializing context, page and test related classes")
    public void setUp() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate(ConfigManager.get("baseUrl"));
        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        registerPage = new RegisterPage(page);
        loginPageBO = new LoginPageBO(page);
        registerPageBO = new RegisterPageBO(page);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (context != null) {
            context.close();
        }
    }

    @AfterClass
    @Step("Tear down browser and context instance")
    public void tearDownBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
