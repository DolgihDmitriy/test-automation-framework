package ozon.ui.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    protected static final Logger log = LoggerFactory.getLogger(BasePage.class);
    private final String BASE_URL = "https://ozon.by/";
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(BASE_URL);
    }
}
