package com.airbnb.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {

    public static WebDriver getWebDriver() {
        WebDriver driver;

        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        } else if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(45));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));

        return driver;
    }
}
