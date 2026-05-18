package check24.tests.ui.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseUITest {
    protected static final Logger log = LoggerFactory.getLogger(BaseUITest.class);
    protected WebDriver driver;

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        log.info("Driver initialized");
    }

    @AfterEach
    public void tearDownDriver() {
        driver.quit();
        log.info("Closing WebDriver...");
    }
}
