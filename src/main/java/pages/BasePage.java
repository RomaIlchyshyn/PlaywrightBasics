package pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class BasePage {

    protected final Page page;

    protected BasePage(Page page) {
        this.page = page;
    }
    @Step("Get current title")
    public String getTitle() {
        return page.title();
    }

    public String getUrl() {
        return page.url();
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public void goBack() {
        page.goBack();
    }

    public void reload() {
        page.reload();
    }
}
