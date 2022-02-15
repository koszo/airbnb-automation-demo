package com.airbnb.pages;

import com.airbnb.model.SearchData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.airbnb.utils.custom_waits.CustomWaits.waitForElementClickable;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@data-testid='structured-search-input-field-query']")
    private WebElement searchField;
    @FindBy(xpath = "//button[@data-testid='structured-search-input-field-guests-button']")
    private WebElement guestsButton;
    @FindBy(xpath = "//button[@aria-describedby='searchFlow-title-label-stepper-adults'][@aria-label='increase value']")
    private WebElement increaseNumberOfAdultsButton;
    @FindBy(xpath = "//button[@aria-describedby='searchFlow-title-label-stepper-children'][@aria-label='increase value']")
    private WebElement increaseNumberOfChildrenButton;
    @FindBy(xpath = "//button[@data-testid='structured-search-input-search-button']")
    private WebElement searchButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByText(String text) {
        waitAndSendKeys(searchField, text);
    }

    public void selectLocation(String location) {
        driver.findElement(By.xpath("//*[contains(text(), '" + location + "')]")).click();
    }

    public void selectDate(String date) {
        driver.findElement(By.xpath("//div[@data-testid='datepicker-day-" + date + "']")).click();
    }

    public void clickAddPersonsButton(WebElement element, int numberOfPersons) {
        waitForElementClickable(element, driver, 2);
        for (int i = 1; i <= numberOfPersons; i++) {
            waitAndClick(element);
        }
    }

    public void clickSearchButton() {
        waitAndClick(searchButton);
    }

    public void searchByStandardData(SearchData searchData) {
        searchByText(searchData.getLocation());
        selectLocation(searchData.getExactLocation());
        selectDate(searchData.getStartDate());
        selectDate(searchData.getEndDate());
        waitAndClick(guestsButton);
        clickAddPersonsButton(increaseNumberOfAdultsButton, searchData.getNumberOfAdults());
        clickAddPersonsButton(increaseNumberOfChildrenButton, searchData.getNumberOfChildren());
        guestsButton.submit();
    }
}
