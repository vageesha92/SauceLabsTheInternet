package com.example.theinternet.pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InfiniteScrollElement {
    WebDriver driver;

    public InfiniteScrollElement(WebDriver driver) {
        this.driver = driver;
    }

    @FindBys(@FindBy(className = "jscroll-added"))
    public List<WebElement> scroll_divs;

    public WebElement getLastScrollDiv() {
        if (countScrollDivs() == 0) {
            return null;
        } else {
            return driver.findElement(By.cssSelector(".jscroll-added:last-of-type"));
        }
    }

    public int countScrollDivs() {
        return scroll_divs.size();
    }

    public void waitTillScrollDivsReachAboveCount(int threshold) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.className("jscroll-added"), threshold));
    }

}
