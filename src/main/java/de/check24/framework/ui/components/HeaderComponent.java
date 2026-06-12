package de.check24.framework.ui.components;

import de.check24.framework.core.enums.HeaderMenuItem;
import de.check24.framework.core.waits.WaitManager;
import org.openqa.selenium.By;

public class HeaderComponent {

    private static final By ACTIVITIES =
            By.cssSelector(".c24-activities-label ");

    private static final By NOTIFICATIONS =
            By.cssSelector(".c24-notification-label ");

    private static final By LOGIN =
            By.cssSelector(".c24-customer-hover");

    public String getMenuItemText(HeaderMenuItem item) {

        return WaitManager
                .waitForVisible(getLocator(item))
                .getText()
                .trim();
    }

    private By getLocator(HeaderMenuItem item) {

        return switch (item) {

            case ACTIVITIES -> ACTIVITIES;

            case NOTIFICATIONS -> NOTIFICATIONS;

            case LOGIN -> LOGIN;
        };
    }
}
