package com.example.theinternet.pageelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeoLocationElement {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div/button")
    public WebElement button;

    @FindBy(xpath = "//*[@id=\"lat-value\"]")
    public WebElement latitude;

    @FindBy(xpath = "//*[@id=\"long-value\"]")
    public WebElement longitude;

    public void click() {
        button.click();
    }

}
