package com.example.theinternet.saucelabstheinternettests;

import com.example.theinternet.browserutils.AuthDevTool;
import com.example.theinternet.browserutils.AuthUsingAPI;
import com.example.theinternet.page.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicAuthTests extends BaseTest {

    private void assertValidCredentials(BasicAuthPage page) {
        String actual_message = page.message();
        String expected_message = "Congratulations! You must have the proper credentials.";
        Assert.assertEquals(actual_message, expected_message);
    }

    @Test
    public void validLoginCredentialsInURLTest() {
        BasicAuthPage page = new BasicAuthPage(driver);
        page.navigateDirectlyTo();
        assertValidCredentials(page);
    }

    @Test
    public void validLoginCredentialsInHeaderTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        AuthDevTool devtool = new AuthDevTool(driver);
        devtool.setAuthUserPassword("admin", "admin");
        devtool.devToolSetup();
        BasicAuthPage page = new BasicAuthPage(driver);
        page.navigateTo();
        assertValidCredentials(page);
    }

    @Test
    public void validLoginCredentialsSeleniumUserPassApiTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        AuthUsingAPI authenticator = new AuthUsingAPI();
        authenticator.setupAuthentication(driver);
        BasicAuthPage page = new BasicAuthPage(driver);
        page.navigateTo();
        assertValidCredentials(page);
    }
}
