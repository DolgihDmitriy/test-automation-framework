package ozon.ui.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ozon.ui.pages.base.BasePage;

import java.time.Duration;

public class HomePage extends BasePage {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    public static final String PROFILE_MENU_ANONYMOUS = "//div[@data-widget='profileMenuAnonymous']";
    public static final String ORDER_INFO = "//div[@data-widget='orderInfo']";
    public static final String FAVOURITE_COUNTER = "//a[@data-widget='favoriteCounter']";
    public static final String BUCKET = "//a[@data-widget='headerIcon']";
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,TIMEOUT);
    }

    public boolean isHeaderIconVisible(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).isDisplayed();
    }
}
