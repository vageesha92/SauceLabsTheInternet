package com.example.theinternet.page;

import com.example.theinternet.pageelement.ShiftElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;


public class ShiftPage {

    WebDriver driver;
    ShiftElement element;

    public ShiftPage(WebDriver driver) {
        this.driver = driver;
        element = new ShiftElement();
        PageFactory.initElements(driver, element);
    }

    public void navigateTo() {
        driver.get("http://localhost:7080/shifting_content");
    }

    public void clickOnMenu() {
        element.clickOnMenu();
    }

    public void clickOnImage() {
        element.clickOnImage();
    }

    public void clickOnList() {
        element.clickOnList();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public Point galleryLocation() {
        return element.getLocationGallery();
    }

    public Point imgLocation() {
        return element.getLocationImg();
    }

    public void imageSS(Path destination) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element.image));
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        Files.move(screenshot.toPath(), destination);
    }

    public String getContent() {
        return element.getContent();
    }
}
