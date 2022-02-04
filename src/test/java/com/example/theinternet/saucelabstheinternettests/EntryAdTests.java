package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.EntryAdPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EntryAdTests extends BaseTest {

    @Test
    public void adTests() {
        EntryAdPage page = new EntryAdPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        page.navigateTo();
        page.waitTillAdDisplays();
        Assert.assertTrue(page.modalAdDisplayed());
        page.clickOnCloseAd();
        page.refresh();
        Assert.assertFalse(page.modalAdDisplayed());
        page.clickOnEnable();
        page.refresh();
        page.waitTillAdDisplays();
        Assert.assertTrue(page.modalAdDisplayed());
        page.clickOnCloseAd();
    }
}
