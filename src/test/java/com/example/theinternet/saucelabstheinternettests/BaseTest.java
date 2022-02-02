package com.example.theinternet.saucelabstheinternettests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    public void setupTest() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.close();
        }
    }
}
