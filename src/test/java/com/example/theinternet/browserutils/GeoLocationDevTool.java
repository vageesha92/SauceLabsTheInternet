package com.example.theinternet.browserutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Optional;

public class GeoLocationDevTool {
    DevTools devtools;

    public GeoLocationDevTool(WebDriver driver) {
        this.devtools = ((ChromeDriver) driver).getDevTools();
    }

    public void DevToolsetup() {
        devtools.createSession();
    }

    public void setCoordinates(Double lattitude, Double longitude, Double accuracy) {
        devtools.send(Emulation.setGeolocationOverride(Optional.of(lattitude), Optional.of(longitude), Optional.of(accuracy)));
    }

    public void DevToolteardown() {
        devtools.close();
    }
}
