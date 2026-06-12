package de.check24.framework.ui.components;

import de.check24.framework.core.waits.WaitManager;
import org.openqa.selenium.By;

public class CookieComponent extends BaseComponent {
    private static final By ACCEPT_COOKIE_BUTTON = By.cssSelector("a.c24-cookie-consent-functional");

    public void acceptCookies() {
        WaitManager.waitForClickable(ACCEPT_COOKIE_BUTTON).click();
    }
}
