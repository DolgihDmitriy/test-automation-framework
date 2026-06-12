package de.check24.tests.ui.home;

import de.check24.framework.core.enums.HeaderMenuItem;
import de.check24.framework.ui.pages.HomePage;
import de.check24.tests.ui.base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeTest extends BaseTest {

    @Test
    @Description("Verify that user can open home page, accept cookies and see the copyright text")
    @DisplayName("HomeTest: Copyright text")
    public void shouldDisplayCopyright() {
        final String expectedCopyrightText = "© 2026 CHECK24 Vergleichsportal GmbH München";
        String actualCopyRightText = new HomePage().open().footer().getCopyrightText();
        assertThat(actualCopyRightText)
                .isEqualTo(expectedCopyrightText);
    }

    @ParameterizedTest
    @EnumSource(HeaderMenuItem.class)
    @Description("Verify that user can open home page, accept cookies and see the text of header icons")
    @DisplayName("HomeTest: Header icons text")
    void shouldDisplayCorrectHeaderMenuText(HeaderMenuItem item) {

        HomePage homePage =
                new HomePage()
                        .open();

        String actualText =
                homePage
                        .header()
                        .getMenuItemText(item);

        assertThat(actualText).isEqualTo(item.expectedText());
        log.info(
                "Running {} on thread {}",
                item,
                Thread.currentThread().getName()
        );
    }
}
