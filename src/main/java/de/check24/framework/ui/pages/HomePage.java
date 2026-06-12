package de.check24.framework.ui.pages;

import de.check24.framework.core.config.ConfigReader;
import de.check24.framework.ui.components.CookieComponent;
import de.check24.framework.ui.components.FooterComponent;
import de.check24.framework.ui.components.HeaderComponent;

public class HomePage extends BasePage{

    private final CookieComponent cookieBanner = new CookieComponent();
    private final FooterComponent footerComponent = new FooterComponent();
    private final HeaderComponent header = new HeaderComponent();

    public FooterComponent footer() {
        return footerComponent;
    }

    public HeaderComponent header() {
        return header;
    }

    public HomePage open() {
        driver.get(ConfigReader.CONFIG.baseUrl());
        cookieBanner.acceptCookies();
        return this;
    }
}