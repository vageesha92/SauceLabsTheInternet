package com.example.theinternet.pageelement;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StatusCodesElement {

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[1]/a")
    WebElement success;

    public void clickOnCode() {
        success.click();
    }
}
