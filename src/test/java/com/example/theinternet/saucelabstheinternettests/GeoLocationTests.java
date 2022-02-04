package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.browserutils.GeoLocationDevTool;
import com.example.theinternet.page.GeoLocationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GeoLocationTests extends BaseTest {

    @Test
    public void coordinatesTests() {
        GeoLocationPage page = new GeoLocationPage(driver);
        GeoLocationDevTool devTool = new GeoLocationDevTool(driver);
        Double expected_latitude = 52.0;
        Double expected_longitude = -100.0;
        Double accuracy = 98.0;
        devTool.DevToolsetup();
        devTool.setCoordinates(expected_latitude, expected_longitude, accuracy);
        page.navgateTo();
        page.clickButton();
        List<Double> actual_coordinates = page.currentCoordinates();
        Assert.assertEquals(expected_latitude, actual_coordinates.get(0), 0.1);
        Assert.assertEquals(expected_longitude, actual_coordinates.get(1), 0.1);
        devTool.DevToolteardown();
    }

}
