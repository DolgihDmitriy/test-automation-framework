package by.site7745.ui.pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private final By ITEM_BLOCK_NAME = By.cssSelector(".item-block_name ");
    private final Duration TIMEOUT = Duration.ofSeconds(10);
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,TIMEOUT);
    }

    private List<String> getTexts(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public boolean isSearchPageContains(String searchText) {
        List<String> resultList = getTexts(ITEM_BLOCK_NAME);
        System.out.println(resultList);
        for(String expected: resultList) {
            if(!expected.contains(searchText)) return false;
        }
        return true;
    }
}