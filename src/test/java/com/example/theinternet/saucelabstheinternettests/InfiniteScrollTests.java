package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.InfiniteScrollPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InfiniteScrollTests extends BaseTest {

    @Test
    public void scrollTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        InfiniteScrollPage page = new InfiniteScrollPage(driver);
        page.navigateTo();
        page.waitTillScrollDivsReachAboveCount(0);
        int divs_count_before_scroll = page.countScrollDivs();
        page.performScrollToLastDiv();
        page.waitTillScrollDivsReachAboveCount(divs_count_before_scroll);
        int divs_count_after_scroll = page.countScrollDivs();
        Assert.assertTrue(divs_count_after_scroll > divs_count_before_scroll);
    }
}
