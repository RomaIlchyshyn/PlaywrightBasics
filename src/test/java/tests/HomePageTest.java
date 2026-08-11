package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageIsOpened() {

        HomePage homePage = new HomePage(page);

        assertThat(homePage.getTitle())
                .isEqualTo("Demo Web Shop");
    }
}