package base;

import bo.LoginPageBO;
import bo.RegisterPageBO;
import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ConfigManager;

import java.nio.file.Paths;


public abstract class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected LoginPageBO loginPageBO;
    protected RegisterPageBO registerPageBO;

    protected BaseTest() {
    }

    @BeforeClass
    public void setUpBrowser() {
        playwright = Playwright.create();
        boolean headless = Boolean.parseBoolean(ConfigManager.get("headless"));
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
    }

    @BeforeMethod
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
        if (!result.isSuccess() && page != null) {
            String screenshotPath = "build/screenshots/" + result.getName() + ".png";
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
        }
        if (context != null) {
            context.close();
        }
    }

    @AfterClass
    public void tearDownBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
