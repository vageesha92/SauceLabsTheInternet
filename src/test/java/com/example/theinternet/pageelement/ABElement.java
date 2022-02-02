package com.example.theinternet.pageelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABElement {
      WebDriver driver;

    @FindBy(xpath= "//*[@id=\"content\"]/div/h3")
    WebElement header;

    public String getHeading(){
        return header.getText();
    }
}
