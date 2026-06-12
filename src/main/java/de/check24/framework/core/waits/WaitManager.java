package de.check24.framework.core.waits;

import de.check24.framework.core.config.ConfigReader;
import de.check24.framework.core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitManager {

    private WaitManager() {}

    public static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigReader.CONFIG.timeout()));
    }

    public static WebElement waitForVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return  getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForInvisible(By locator) {
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
