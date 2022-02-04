package com.example.theinternet.page;

import com.example.theinternet.pageelement.EntryAdElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class EntryAdPage {

    WebDriver driver;
    EntryAdElement element;

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
        element = new EntryAdElement()
        ;
        PageFactory.initElements(driver, element);
    }

    public void waitTillAdDisplays() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(element.closeAd));
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void clickOnCloseAd() {
        element.clickOnCloseAd();
    }

    public void navigateTo() {
        driver.get("http://localhost:7080/entry_ad");
    }

    public void clickOnEnable() {
        element.clickOnEnable();
    }

    public boolean modalAdDisplayed() {
        return element.modalVisible();
    }


}
