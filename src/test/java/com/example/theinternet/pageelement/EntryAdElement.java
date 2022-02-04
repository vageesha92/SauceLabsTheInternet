package com.example.theinternet.pageelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryAdElement {

    @FindBy(css = "#modal > div.modal > div.modal-footer > p")
    public WebElement closeAd;

    @FindBy(id = "modal")
    public WebElement modal;

    @FindBy(id = "restart-ad")
    WebElement enable;

    public void clickOnCloseAd() {
        closeAd.click();
    }

    public Boolean modalVisible() {
        return modal.isDisplayed();
    }

    public void clickOnEnable() {
        enable.click();
    }
}
