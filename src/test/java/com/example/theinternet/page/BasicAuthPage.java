package com.example.theinternet.page;

import com.example.theinternet.pageelement.BasicAuthElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasicAuthPage {

    WebDriver driver;
    BasicAuthElement element;

    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        element = new BasicAuthElement();
        PageFactory.initElements(driver, element);
    }

    public void navigateDirectlyTo() {
        driver.get("http://admin:admin@localhost:7080/basic_auth");
    }

    public void navigateTo() {
        driver.get("http://localhost:7080/basic_auth");
    }

    public String message() {
        return element.message();
    }
}
