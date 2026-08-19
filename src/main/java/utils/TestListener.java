package utils;

import base.BaseTest;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;


public class TestListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        log.info(">>>>> Test started: '{}'", testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        log.info("<<<<< Test passed: '{}'\n", testName);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        log.error(
                "Test failed: '{}' | Reason {}",
                testName,
                result.getThrowable().getMessage()
        );
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            Page page = ((BaseTest) testInstance).getPage();
            if (page != null) {
                try {
                    log.info("Taking screenshot for report");
                    byte[] screenshotBytes = page.screenshot(
                            new Page.ScreenshotOptions().setFullPage(true)
                    );
                    Allure.addAttachment("Failure_Screenshot_ " + testName, "image/png", new ByteArrayInputStream(screenshotBytes), "png");

                } catch (Exception e) {
                    log.error(
                            "Can't take screenshot: {}",
                            e.getMessage()
                    );
                }
            }
        }
    }
}

