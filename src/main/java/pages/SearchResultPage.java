package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class SearchResultPage extends BasePage {
    private final Locator productItems;
    private final Locator noResultsMessage;

    public SearchResultPage(Page page) {
        super(page);
        productItems = page.locator(".product-item");
        noResultsMessage = page.locator(".result");
    }
    @Step("Verify that product : {productName} is displayed")
    public void verifyProductIsDisplayed(String productName) {
        Locator product = productItems.filter(new Locator.FilterOptions().setHasText(productName)).first();
        assertThat(product).isVisible();
    }
    @Step("Verify that there are no results on the page")
    public void verifyNoResults() {
        assertThat(noResultsMessage).isVisible();
    }
}
