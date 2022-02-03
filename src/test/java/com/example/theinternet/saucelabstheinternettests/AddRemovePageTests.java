package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.AddRemovePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemovePageTests extends BaseTest {

    @Test
    public void onlyAddTest() {
        AddRemovePage page = new AddRemovePage(driver);
        page.navigateTo();
        int number_of_buttons_to_add = 5;
        page.performMultipleClickOnAdd(number_of_buttons_to_add);
        int expected_button_count = number_of_buttons_to_add;
        Assert.assertEquals(page.countButtons(), expected_button_count);
    }

    @Test
    public void addAndRemoveOnceTest() {
        AddRemovePage page = new AddRemovePage(driver);
        page.navigateTo();
        page.performMultipleClickOnAdd(1);
        page.deleteButton(1);
        int expected_button_count = 0;
        Assert.assertEquals(page.countButtons(), expected_button_count);
    }

    @Test
    public void bothAddAndRemoveTest() {
        AddRemovePage page = new AddRemovePage(driver);
        page.navigateTo();
        int number_of_buttons_to_add = 5;
        int number_of_buttons_to_remove = 3;
        page.performMultipleClickOnAdd(number_of_buttons_to_add);
        for (int count_button_remove = 0; count_button_remove < number_of_buttons_to_remove; count_button_remove++) {
            page.deleteButton(1);
        }
        int expected_button_count = number_of_buttons_to_add - number_of_buttons_to_remove;
        Assert.assertEquals(page.countButtons(), expected_button_count);
    }

}
