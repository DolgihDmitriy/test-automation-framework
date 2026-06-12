package de.check24.framework.ui.components;

import org.openqa.selenium.By;

public class FooterComponent extends BaseComponent{

    private static final By COPYRIGHT_TEXT = By.cssSelector("div.c24-footer-company-line");

    public String getCopyrightText() {
        return driver.findElement(COPYRIGHT_TEXT).getText();
    }
}
