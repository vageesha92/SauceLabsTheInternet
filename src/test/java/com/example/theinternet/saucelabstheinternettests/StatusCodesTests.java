package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.StatusCodesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatusCodesTests extends BaseTest {

    @Test
    public void codesTest() {
        StatusCodesPage page = new StatusCodesPage(driver);
        page.navigateTo();
        page.clickOnCode();
        page.getCode();
        Assert.assertEquals(page.getCode(), 200);

    }
}
