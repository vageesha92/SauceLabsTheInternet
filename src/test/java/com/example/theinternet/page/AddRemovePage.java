package com.example.theinternet.page;

import com.example.theinternet.pageelement.AddRemovePageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddRemovePage {
    AddRemovePageElement elements;
    WebDriver driver;

    public AddRemovePage(WebDriver driver) {
        this.driver = driver;
        this.elements = new AddRemovePageElement(driver);
        PageFactory.initElements(driver, elements);
    }

    private void performMultipleClick(int click_count, WebElement element) {
        int i = 0;
        while (i < click_count) {
            element.click();
            i++;
        }
    }

    public void navigateTo() {
        driver.get("http://localhost:7080/add_remove_elements/");
    }

    public void performMultipleClickOnAdd(int click_count) {
        performMultipleClick(click_count, elements.addbutton);
    }

    public void performSingleClick(WebElement element) {
        performMultipleClick(1, element);
    }

    public void deleteButton(int index) {
        performSingleClick(elements.getButtonAtIndex(index));
    }

    public int countButtons() {
        return elements.allButtons.size();
    }
}
