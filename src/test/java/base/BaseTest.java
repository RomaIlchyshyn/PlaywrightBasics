package base;

import com.microsoft.playwright.*;
import lombok.AllArgsConstructor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@AllArgsConstructor
public abstract class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected BaseTest() {
    }

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        context = browser.newContext();

        page = context.newPage();

        page.navigate("https://demowebshop.tricentis.com");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(!result.isSuccess() && page != null) {
            page.screenshot();
        }
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
