package de.check24.ui.pages.search;

import de.check24.ui.pages.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final int targetDate = LocalDate.now().getDayOfMonth()+4;

    private final String SPLASH_SCREEN_BUTTON_CLOSE = "//div[@id='splashScreenContainer']//div[contains(@class, 'close')]";

    private final String DESTINATION_INPUT = "//input[@data-test-id-qa='destination-suggestion-input']";

    private final String DATA_RANGE_PICKER_INPUT = "//div[@data-test-id-qa='date-range-picker-input']";

    private final String DATA_TODAY_BUTTON = "//button[contains(@aria-label, 'Today')]";

    private final String DATA_ONE_WEEK_LATER_BUTTON = "//button[contains(@aria-label,'"+targetDate+"')]";

    private final String SUBMIT_BUTTON = "//button[@data-test-id-qa='submit']";

    private final String SUCHEN_SUBMIT_BUTTON = "//button[@data-test-id-qa='submit']";

    private final String RESULT_LIST_HOTEL_RESULT = "//div[@data-test-id-qa='results-list-hotel-result']";

    private final String HOTEL_NAME = ".//span[@data-test-id-qa='hotel-name']";

    private final String RESULT_LOCATION = ".//div[contains(@class,'hotelResultLocation')]";

    public void clickSplashScreenButtonClose() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SPLASH_SCREEN_BUTTON_CLOSE))).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDestination(String input) {
        WebElement element = driver.findElement(By.xpath(DESTINATION_INPUT));
        element.clear();
        element.sendKeys(input);
        element.sendKeys(Keys.ENTER);
    }

    public void clickDataRangePickerInput() {
        driver.findElement(By.xpath(DATA_RANGE_PICKER_INPUT)).click();
    }

    public void clickDataTodayButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DATA_TODAY_BUTTON))).click();
    }

    public void clickDataOneWeekLaterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DATA_ONE_WEEK_LATER_BUTTON))).click();
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SUBMIT_BUTTON))).click();
    }

    public void scrollScreenToTheEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(RESULT_LIST_HOTEL_RESULT)));
    }

    private List<WebElement> getHotels(String locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public boolean isHotelResultListContainsCity(String city) {
        List<WebElement> hotelCards = getHotels(RESULT_LIST_HOTEL_RESULT);

        if (hotelCards.isEmpty()) return false;

        String lowerCaseCity = city.toLowerCase();

        return hotelCards.stream().allMatch(card -> {
            String hotelNameText = card.findElement(By.xpath(HOTEL_NAME)).getText().toLowerCase().trim();

            String addressText = card.findElement(By.xpath(RESULT_LOCATION)).getText().toLowerCase().trim();

            return hotelNameText.contains(lowerCaseCity) || addressText.contains(lowerCaseCity);
        });
    }

}