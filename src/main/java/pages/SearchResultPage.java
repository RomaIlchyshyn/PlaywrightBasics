package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class SearchResultPage extends BasePage{
    private final Locator productItems;
    private final Locator noResultsMessage;

    public SearchResultPage(Page page) {
        super(page);
        productItems = page.locator(".product-item");
        noResultsMessage = page.locator(".result");
    }

    public void verifyProductIsDisplayed(String productName) {
        Locator product = productItems
                .filter(new Locator.FilterOptions()
                        .setHasText(productName))
                .first();
        assertThat(product).isVisible();
    }
    public void verifyNoResults() {
        assertThat(noResultsMessage).isVisible();
    }
}
