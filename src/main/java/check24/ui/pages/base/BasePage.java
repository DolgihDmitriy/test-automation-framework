package check24.ui.pages.base;

import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class BasePage {
    protected static final Logger log = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    protected final String BASE_URL = "https://www.check24.de/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        log.info("Открытие главной страницы: {}", BASE_URL);
        driver.get(BASE_URL);
    }

}
