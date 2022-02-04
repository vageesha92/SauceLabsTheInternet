package com.example.theinternet.page;

import com.example.theinternet.pageelement.DropdownElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {
    WebDriver driver;
    DropdownElement element;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        element = new DropdownElement();
        PageFactory.initElements(driver, element);
    }

    public void naviagteTo() {
        driver.get("http://localhost:7080/dropdown");
    }

    public List<String> dropDownOptionsToSelectByText() {
        List<WebElement> options = element.optionsToSelect();
        return options.stream().filter(element -> element.isEnabled()).map(element -> element.getText()).collect(Collectors.toList());
    }

    public List<String> dropDownOptionsToSelectByValue() {

        List<WebElement> options = element.optionsToSelect();
        return options.stream().filter(element -> element.isEnabled()).map(element -> element.getAttribute("value")).collect(Collectors.toList());
    }

    public void selectOptionByText(String option_text) {
        element.selectOptionByText(option_text);
    }

    public void selectOptionByValue(String option_value) {
        element.selectOptionByValue(option_value);
    }

    public String getSelectedOptionText() {
        return element.getSelectedOption().getText();
    }

    public String getSelectedOptionValue() {
        return element.getSelectedOption().getAttribute("value");
    }
}
