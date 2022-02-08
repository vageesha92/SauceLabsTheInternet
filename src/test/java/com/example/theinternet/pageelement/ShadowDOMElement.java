package com.example.theinternet.pageelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ShadowDOMElement {

    WebDriver driver;
    @FindBys(@FindBy(css = "#content > my-paragraph"))
    public List<WebElement> my_paragraph_elements;
}
