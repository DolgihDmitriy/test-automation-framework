package de.check24.ui.pages.home;

import de.check24.ui.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final String COOKIE_CONSENT_BUTTON = "//div[contains(@class, 'c24-cookie-consent-notice-buttons')]//a[@class='c24-cookie-consent-button']";

    private final String QUICK_CHIPS_LINK_HOTEL = "//a[@data-identifier='hotel']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickCookieConsentButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COOKIE_CONSENT_BUTTON))).click();
    }

    public void clickQuickChipsLinkHotel() {
        driver.findElement(By.xpath(QUICK_CHIPS_LINK_HOTEL)).click();
    }
}
