package com.example.theinternet.page;

import com.example.theinternet.pageelement.ShadowDOMElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShadowDOMPage {

    ShadowDOMElement element;
    WebDriver driver;

    public ShadowDOMPage(WebDriver driver) {
        this.driver = driver;
        element = new ShadowDOMElement();
        PageFactory.initElements(driver, element);
    }

    public void navigateTo() {
        driver.get("http://localhost:7080/shadowdom");
    }

    public List<WebElement> getMyParagraphs() {
        return element.my_paragraph_elements;
    }


}
