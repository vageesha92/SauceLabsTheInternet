package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.page.ShadowDOMPage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ShadowDOMTests extends BaseTest {

    @Test
    public void testShadowDOM() {
        ShadowDOMPage page = new ShadowDOMPage(driver);
        page.navigateTo();
        List<WebElement> my_paragraphs = page.getMyParagraphs();
        List<String> expected_text_inside_shadow_para = List.of(
                "Let's have some different text!",
                "Let's have some different text!\nIn a list!");
        for (int i = 0; i < my_paragraphs.size(); i++) {
            WebElement para = my_paragraphs.get(i);
            SearchContext shadow = para.getShadowRoot();
            String text_inside_shadow_para = shadow.findElement(By.cssSelector("p")).getText();
            Assert.assertEquals(text_inside_shadow_para, expected_text_inside_shadow_para.get(i));
        }
    }
}
