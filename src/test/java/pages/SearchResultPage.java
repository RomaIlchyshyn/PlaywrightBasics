package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class SearchResultPage extends BasePage{
    private final Locator productItems;

    public SearchResultPage(Page page) {
        super(page);
        productItems = page.locator(".product-item");
    }

    public boolean isProductDisplayed(String productName) {
        productItems
                .filter(new Locator.FilterOptions()
                        .setHasText(productName))
                .first();
        productItems.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return productItems.isVisible();
    }
}
