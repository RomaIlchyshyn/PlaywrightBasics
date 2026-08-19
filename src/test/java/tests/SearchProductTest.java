package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import constants.ConstantsStorage;


public class SearchProductTest extends BaseTest {
    private SearchResultPage searchResultPage;

    @Test
    public void verifySuccessfulSearch() {
        searchResultPage = homePage.searchProduct(ConstantsStorage.SEARCH_QUERY);
        searchResultPage.verifyProductIsDisplayed(ConstantsStorage.SEARCH_QUERY);
    }

    @Test
    public void verifySearchWithUnexistentProduct() {
        searchResultPage = homePage.searchProduct(ConstantsStorage.NON_EXISTENT_SEARCH_QUERY);
        searchResultPage.verifyNoResults();
    }
}
