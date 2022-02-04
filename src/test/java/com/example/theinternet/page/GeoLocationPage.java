package com.example.theinternet.page;

import com.example.theinternet.pageelement.GeoLocationElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GeoLocationPage {
    WebDriver driver;
    GeoLocationElement element;

    public GeoLocationPage(WebDriver driver) {
        element = new GeoLocationElement();
        this.driver = driver;
        PageFactory.initElements(driver, element);
    }

    public void navgateTo() {
        driver.get("http://localhost:7080/geolocation");
    }

    public void clickButton() {
        element.click();
    }

    public List<Double> currentCoordinates() {
        Double latitude = Double.valueOf(element.latitude.getText());
        Double longitude = Double.valueOf(element.longitude.getText());
        return List.of(latitude, longitude);
    }
}
