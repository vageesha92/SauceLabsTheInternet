package com.example.theinternet.pageelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuthElement {
    WebDriver driver;

    @FindBy(xpath = "//p")
    WebElement page_message;

    public String message() {
        return page_message.getText();
    }
}
