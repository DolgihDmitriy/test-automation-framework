package de.check24.framework.ui.components;

import de.check24.framework.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent {

    protected final WebDriver driver;

    protected BaseComponent() {
        driver = DriverManager.getDriver();
    }
}
