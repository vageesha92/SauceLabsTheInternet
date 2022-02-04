package com.example.theinternet.pageelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownElement {

    @FindBy(id = "dropdown")
    WebElement element;

    public List<WebElement> optionsToSelect() {
        Select dropdown = new Select(element);
        return dropdown.getOptions();
    }


    public void selectOptionByText(String option_text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(option_text);
    }

    public void selectOptionByValue(String option_value) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(option_value);
    }


    public WebElement getSelectedOption() {
        Select dropdown = new Select(element);
        return dropdown.getFirstSelectedOption();
    }

}
