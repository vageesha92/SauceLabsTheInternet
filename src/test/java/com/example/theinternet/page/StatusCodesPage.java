package com.example.theinternet.page;

import com.example.theinternet.pageelement.StatusCodesElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class StatusCodesPage {

    WebDriver driver;
    StatusCodesElement element;

    public StatusCodesPage(WebDriver driver) {
        this.driver = driver;
        element = new StatusCodesElement();
        PageFactory.initElements(driver, element);
    }

    public void navigateTo() {
        driver.get("http://localhost:7080/status_codes");
    }

    public void clickOnCode() {
        element.clickOnCode();
    }

    public int getCode() {
        int code = 0;
        try {
            HttpURLConnection con =
                    (HttpURLConnection) new URL(" http://localhost:7080/status_codes/200")
                            .openConnection();
            con.setRequestMethod("GET");
            con.connect();
            code = con.getResponseCode();
        } catch (IOException e) {
            System.out.println("Not found");
        }
        return code;
    }
}
