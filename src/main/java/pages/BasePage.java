package pages;

import com.microsoft.playwright.*;

public class BasePage {

    protected final Page page;

    protected BasePage(Page page) {
        this.page = page;
    }

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
