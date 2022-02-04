package com.example.theinternet.page;

import com.example.theinternet.pageelement.ContextMenuElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ContextMenuPage {

    WebDriver driver;
    ContextMenuElement element;

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        element = new ContextMenuElement();
        PageFactory.initElements(driver, element);
    }

    public void rightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(element.box).build().perform();
    }

    public void navigateTo() {
        driver.get(("http://localhost:7080/context_menu"));
    }

    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void switchToAlert() {
        driver.switchTo().alert().accept();
    }

    public void closeMenu() {
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ESCAPE);
            r.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
