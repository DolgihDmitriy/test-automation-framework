package ozon.tests.ui.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class BaseUITest {
    protected static final Logger log = LoggerFactory.getLogger(BaseUITest.class);
    protected WebDriver driver;

    @BeforeEach
    public void initDriver() {
        log.info("Driver initialization with anti-bot bypass...");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-blink-features=AutomationControlled");

        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36");

        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDownDriver() {
        driver.quit();
        log.info("Closing driver...");
    }
}
