package com.airbnb.utils.custom_waits;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormatSymbols;
import java.time.Duration;


public class CustomWaits {

    private static WebDriverWait wait;

    public static void waitForElementClickable(WebElement element, WebDriver driver, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementVisible(WebElement element, WebDriver driver, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This methods transforms the month number into short month string (eg. 03 to Mar)
     *
     * @param month eg. 03 to Mar
     * @return string
     */
    public static String getMonth(int month) {
        return new DateFormatSymbols().getShortMonths()[month - 1];
    }

    public static void scrollToElement(WebElement element, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public static boolean isElementDisplayed(WebElement element, WebDriver driver) {
        try {
            waitForElementVisible(element, driver, 3);
            if (element.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
        return false;
    }
        }
