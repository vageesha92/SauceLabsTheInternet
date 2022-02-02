package com.example.theinternet.page;

import com.example.theinternet.pageelement.ABElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ABPage {

    ABElement element;
    WebDriver driver;

    public ABPage(WebDriver driver){
        this.driver = driver;
        element = new ABElement();
        PageFactory.initElements(driver, element);
    }

    public void navigateTo(){
        driver.get("http://localhost:7080/abtest");
    }

    public String getHeading(){
        return element.getHeading();
    }
}
