package com.example.theinternet.browserutils;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;

public class AuthUsingAPI {

    public void setupAuthentication(WebDriver driver) {
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(() -> new UsernameAndPassword("admin", "admin"));
    }
}
