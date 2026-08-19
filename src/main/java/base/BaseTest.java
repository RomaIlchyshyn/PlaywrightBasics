package base;

import com.microsoft.playwright.*;
import lombok.AllArgsConstructor;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ConfigManager;
import java.nio.file.Paths;


public abstract class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

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
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(!result.isSuccess() && page != null) {
            String screenshotPath = "build/screenshots/" + result.getName() + ".png";
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
        }
        if (context != null) {
            context.close();
        }
    }
    @AfterClass
    public void tearDownBrowser() {
        if(browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
