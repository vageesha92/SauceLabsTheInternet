package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.ABPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ABTests extends BaseTest {

    @Test
    public void HeadersTest(){
        ABPage page = new ABPage(driver);
        page.navigateTo();
        String actual_header = page.getHeading();
        List<String> expected_headers = List.of("No A/B Test", "A/B Test Variation 1", "A/B Test Control");
        Assert.assertTrue(expected_headers.contains(actual_header));
    }
}
