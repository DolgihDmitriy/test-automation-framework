package de.check24.framework.ui.pages;

import de.check24.framework.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final WebDriver driver;
    protected  BasePage() {
        this.driver = DriverManager.getDriver();
    }
}