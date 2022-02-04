package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class ContextMenuTests extends BaseTest {

    @Test
    public void rightClick() {
        ContextMenuPage page = new ContextMenuPage(driver);
        page.navigateTo();
        page.rightClick();
        Assert.assertTrue(page.isAlertPresent());
        page.switchToAlert();
        page.closeMenu();
        Assert.assertFalse(page.isAlertPresent());

    }
}
