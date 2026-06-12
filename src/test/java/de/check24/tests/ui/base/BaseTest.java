package de.check24.tests.ui.base;

import de.check24.framework.core.config.ConfigReader;
import de.check24.framework.core.driver.BrowserFactory;
import de.check24.framework.core.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {
    public static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    public void initDriver() {
        DriverManager.setDriver(BrowserFactory.createDriver(
                ConfigReader.CONFIG.browser(),
                ConfigReader.CONFIG.headless()));
        log.info("Starting test on browser: {}\n Headless mode: {}",
                ConfigReader.CONFIG.browser(),ConfigReader.CONFIG.headless());
        log.info(
                "Thread: {}",
                Thread.currentThread().getName()
        );
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
        log.info("tearDown driver");
    }
}