package tests;

import Constants.ConstatsStorage;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchProductTest extends BaseTest {

    @Test
    public void verifySuccessfulSearch() {
        HomePage homePage = new HomePage(page);
        SearchResultPage searchResultPage = homePage.searchProduct(ConstatsStorage.SEARCH_QUERY);
        assertThat(searchResultPage.isProductDisplayed(ConstatsStorage.SEARCH_QUERY)).isTrue();

    }
}
