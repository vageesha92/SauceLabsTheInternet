package com.example.theinternet.pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AddRemovePageElement {

    private WebDriver driver;

    public AddRemovePageElement(WebDriver driver) {
        this.driver = driver;
    }

    @FindBys(@FindBy(xpath = "//*[@id=\"elements\"]/button"))
    public List<WebElement> allButtons;

    @FindBy(xpath = "/html/body/div[2]/div/div/button")
    public WebElement addbutton;


    public WebElement getButtonAtIndex(int index) {
        return driver.findElement(By.xpath(
                String.format("/html/body/div[2]/div/div/div/button[%d]", index)));
    }
}


