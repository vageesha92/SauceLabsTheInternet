package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.DropDownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class DropdownTests extends BaseTest {

    @Test
    public void readSelectOptionsTest() {
        DropDownPage page = new DropDownPage(driver);
        page.naviagteTo();
        List<String> options = page.dropDownOptionsToSelectByValue();
        int expected_options_count = 2;
        Assert.assertEquals(options.size(), expected_options_count);
    }

    @Test
    public void pickSelectOptionByTextTest() {
        pickSelectOptionHelper(page -> page.dropDownOptionsToSelectByText(),
                page -> page.getSelectedOptionText(),
                (page, option) -> page.selectOptionByText(option));
    }

    @Test
    public void pickSelectOptionByValueTest() {
        pickSelectOptionHelper(page -> page.dropDownOptionsToSelectByValue(),
                page -> page.getSelectedOptionValue(),
                (page, option) -> page.selectOptionByValue(option));
    }

    private void pickSelectOptionHelper(Function<DropDownPage, List<String>> dropDownOptionsToSelect,
                                        Function<DropDownPage, String> getSelectedOption,
                                        BiConsumer<DropDownPage, String> selectOption) {
        DropDownPage page = new DropDownPage(driver);
        page.naviagteTo();
        List<String> options = dropDownOptionsToSelect.apply(page);
        for (String option : options) {
            selectOption.accept(page, option);
            String selected_option = getSelectedOption.apply(page);
            Assert.assertEquals(selected_option, option);
        }
    }
}



