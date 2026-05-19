package de.check24.tests.ui;

import de.check24.ui.pages.home.HomePage;
import de.check24.ui.pages.search.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseUITest{

    private HomePage homePage;
    private SearchPage searchPage;

    @BeforeEach
    public void openHomePage() {
        homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickCookieConsentButton();
        searchPage = new SearchPage(driver);
    }

    @Test
    @DisplayName("Test for search functionality")
    public void testSearchFunction() {
        homePage.clickQuickChipsLinkHotel();
        searchPage.clickSplashScreenButtonClose();
        searchPage.setDestination("Köln");
        searchPage.clickDataRangePickerInput();
        searchPage.clickDataTodayButton();
        searchPage.clickDataOneWeekLaterButton();
        searchPage.clickSubmitButton();
        searchPage.scrollScreenToTheEnd();

        assertThat(searchPage.isHotelResultListContainsCity("Köln")).isTrue();
    }
}
