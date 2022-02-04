package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.DragandDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class DragandDropTests extends BaseTest {

    // Unfortunately Selenium does not work with HTML5 drag and drop.
    // See : https://github.com/SeleniumHQ/selenium-google-code-issue-archive/issues/3604
    @Test(enabled = false)
    public void testDragDrop() {
        DragandDropPage page = new DragandDropPage(driver);
        page.navigateTo();
        Assert.assertEquals(page.headerColumnA(), "A");
        Assert.assertEquals(page.headerColumnB(), "B");
        page.performDragDropAction();
        Assert.assertEquals(page.headerColumnA(), "B");
        Assert.assertEquals(page.headerColumnB(), "A");

    }
}
