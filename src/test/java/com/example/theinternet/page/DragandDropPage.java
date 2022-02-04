package com.example.theinternet.page;

import com.example.theinternet.pageelement.DragandDropElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DragandDropPage {

    WebDriver driver;
    DragandDropElement element;

    public DragandDropPage(WebDriver driver) {
        this.driver = driver;
        element = new DragandDropElement();
        PageFactory.initElements(driver, element);
    }

    public void navigateTo() {
        driver.get("http://localhost:7080/drag_and_drop");
    }

    public void performDragDropAction() {
        // Unfortunately Selenium does not work with HTML5 drag and drop.
        Actions action = new Actions(driver);
        WebElement source = element.columnA;
        WebElement destination = element.columnB;
        action.dragAndDrop(source, destination).release().build().perform();
    }


    public String headerColumnA() {
        return element.headerColumnA.getText();
    }

    public String headerColumnB() {
        return element.headerColumnB.getText();
    }

}
