package ozon.tests.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ozon.tests.ui.base.BaseUITest;
import ozon.ui.pages.home.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeTest extends BaseUITest {
    private HomePage homePage;
    @BeforeEach
    public void setUpHomePage() {
        homePage = new HomePage(driver);
        homePage.openHomePage();
    }

    @DisplayName("Test for ozon homePage")
    @ParameterizedTest
    @ValueSource(strings = {HomePage.PROFILE_MENU_ANONYMOUS, HomePage.ORDER_INFO, HomePage.FAVOURITE_COUNTER,HomePage.BUCKET})
    void testOzonHeaderIconVisibility(String locator) {
        assertThat(
                homePage.isHeaderIconVisible(locator))
                .isTrue();
    }
}
