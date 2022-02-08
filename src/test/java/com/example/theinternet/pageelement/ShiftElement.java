package com.example.theinternet.pageelement;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShiftElement {

    @FindBy(xpath = "//*[@id=\"content\"]/div/a[1]")
    WebElement menu;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a[2]")
    public WebElement img;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a[3]")
    WebElement li;

    @FindBy(css = "#content > div > ul > li:nth-child(5) > a")
    WebElement gallery;

    @FindBy(css = "#content > div > img")
    public WebElement image;

    @FindBy(css = "#content > div > div > div")
    WebElement content;

    public void clickOnMenu() {
        menu.click();
    }

    public void clickOnImage() {
        img.click();
    }

    public void clickOnList() {
        li.click();
    }

    public Point getLocationGallery() {
        return gallery.getLocation();
    }

    public Point getLocationImg() {
        return image.getLocation();
    }

    public String getContent() {
        return content.getText();
    }
}
