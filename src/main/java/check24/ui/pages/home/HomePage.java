package check24.ui.pages.home;

import check24.ui.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final String COPYRIGHT_TEXT = "//div[@class='c24-footer-company-line']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getCopyRightText() {
        log.info("Получение текста копирайта...");
        return driver.findElement(By.xpath(COPYRIGHT_TEXT)).getText();
    }
}
