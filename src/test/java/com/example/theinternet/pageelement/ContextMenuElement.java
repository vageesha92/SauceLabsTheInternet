package com.example.theinternet.pageelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuElement {

    WebDriver driver;

    @FindBy(id = "hot-spot")
    public WebElement box;
}
