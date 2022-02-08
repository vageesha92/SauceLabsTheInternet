package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.ShiftPage;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShiftTests extends BaseTest {

    @Test
    public void shiftGalleryTest() {
        ShiftPage page = new ShiftPage(driver);
        page.navigateTo();
        page.clickOnMenu();
        Point position_before_refresh = page.galleryLocation();
        page.refreshPage();
        Point position_after_refresh = page.galleryLocation();
        Assert.assertEquals(position_before_refresh.getX(), position_after_refresh.getX());
    }

    @Test
    public void shiftImgTest() throws IOException {
        ShiftPage page = new ShiftPage(driver);
        page.navigateTo();
        page.clickOnImage();
        Path before_refresh_screenshot = Paths.get("before_refresh.png");
        page.imageSS(before_refresh_screenshot);
        Point position_before_refresh = page.imgLocation();
        page.refreshPage();
        Point position_after_refresh = page.imgLocation();
        try {
            Assert.assertEquals(position_before_refresh.getX(), position_after_refresh.getX());
        } catch (AssertionError e) {
            page.imageSS(Paths.get("after_refresh_test_failed.png"));
            throw e;
        }
        Files.delete(before_refresh_screenshot);
    }

    @Test
    public void shiftContentTest() {
        ShiftPage page = new ShiftPage(driver);
        page.navigateTo();
        page.clickOnList();
        String before = page.getContent();
        page.refreshPage();
        String after = page.getContent();
        Assert.assertNotEquals(before, after);
    }
}
