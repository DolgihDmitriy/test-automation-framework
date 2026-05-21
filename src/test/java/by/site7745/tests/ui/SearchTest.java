package by.site7745.tests.ui;

import by.site7745.ui.pages.home.HomePage;
import by.site7745.ui.pages.search.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    private HomePage homePage;
    private SearchPage searchPage;
    private WebDriver driver;

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://7745.by/");
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    @DisplayName("Test search for site 7745.by")
    void test7745() {
        homePage.clickCookieButton();
        homePage.fillSearchInput("лопата");
        homePage.clickSearchButton();

        assertThat(searchPage.isSearchPageContains("Лопата")).isTrue();
    }

    @AfterEach
    public void tearDownDriver() {
        driver.quit();
    }
}