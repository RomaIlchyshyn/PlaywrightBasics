package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import static constants.ConstantsStorage.NON_EXISTENT_SEARCH_QUERY;
import static constants.ConstantsStorage.SEARCH_QUERY;


public class SearchProductTest extends BaseTest {
    private SearchResultPage searchResultPage;

    @Test
    public void verifySuccessfulSearch() {
        searchResultPage = homePage.searchProduct(SEARCH_QUERY);
        searchResultPage.verifyProductIsDisplayed(SEARCH_QUERY);
    }

    @Test
    public void verifySearchWithUnexistentProduct() {
        searchResultPage = homePage.searchProduct(NON_EXISTENT_SEARCH_QUERY);
        searchResultPage.verifyNoResults();
    }
}
