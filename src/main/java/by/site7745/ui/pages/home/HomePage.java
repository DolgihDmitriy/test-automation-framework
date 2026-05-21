package by.site7745.ui.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final By COOKIE_BUTTON = By.id("dldkdAccept");
    private final By SEARCH_INPUT = By.id("search");
    private final By SEARCH_BUTTON  = By.xpath("//button[@class='btn btn-search']");

    private final Duration TIMEOUT = Duration.ofSeconds(10);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,TIMEOUT);
    }

    public void clickCookieButton() {
        wait.until(ExpectedConditions.elementToBeClickable(COOKIE_BUTTON)).click();
    }

    public void fillSearchInput(String text) {
        driver.findElement(SEARCH_INPUT).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(SEARCH_BUTTON).click();
    }
}