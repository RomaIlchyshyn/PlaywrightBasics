package tests;

import сonstants.ConstantsStorage;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;


public class SearchProductTest extends BaseTest {

    @Test
    public void verifySuccessfulSearch() {
        HomePage homePage = new HomePage(page);
        SearchResultPage searchResultPage = homePage.searchProduct(ConstantsStorage.SEARCH_QUERY);
        searchResultPage.verifyProductIsDisplayed(ConstantsStorage.SEARCH_QUERY);
    }
    @Test
    public void verifySearchWithUnexistentProduct() {
        HomePage homePage = new HomePage(page);
        SearchResultPage searchResultPage = homePage.searchProduct(ConstantsStorage.NON_EXISTENT_SEARCH_QUERY);
        searchResultPage.verifyNoResults();
    }
}
