package com.example.theinternet.page;

import com.example.theinternet.pageelement.InfiniteScrollElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InfiniteScrollPage {

    WebDriver driver;
    JavascriptExecutor js;
    InfiniteScrollElement element;
    ScriptKey scroll_script_key;

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
        element = new InfiniteScrollElement(driver);
        PageFactory.initElements(driver, element);
        js = (JavascriptExecutor) driver;
        scroll_script_key = js.pin("arguments[0].scrollIntoView();");
    }

    public void navigateTo() {
        driver.get("http://localhost:7080/infinite_scroll");
    }

    public int countScrollDivs() {
        return element.countScrollDivs();
    }

    public void waitTillScrollDivsReachAboveCount(int threshold) {
        element.waitTillScrollDivsReachAboveCount(threshold);
    }

    public void performScrollToLastDiv() {
        js.executeScript(scroll_script_key, element.getLastScrollDiv());
    }
}