package com.example.theinternet.pageelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragandDropElement {

    @FindBy(id = "column-a")
    public WebElement columnA;

    @FindBy(id = "column-b")
    public WebElement columnB;

    @FindBy(css = "#column-a > header")
    public WebElement headerColumnA;

    @FindBy(css = "#column-b > header")
    public WebElement headerColumnB;

}
