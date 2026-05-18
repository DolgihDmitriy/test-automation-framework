package check24.tests.ui;

import check24.tests.ui.base.BaseUITest;
import check24.ui.pages.home.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeTest extends BaseUITest {
    private HomePage homePage;

    @BeforeEach
    public void setUpHomePage() {
        homePage = new HomePage(driver);
        homePage.navigateToHomePage();
    }

    @Test
    @DisplayName("task/20260518 - check copyright text")
    void testTask20260518() {
        assertThat(
                homePage.getCopyRightText())
                .isEqualTo("© 2026 CHECK24 Vergleichsportal GmbH München");
    }
}
