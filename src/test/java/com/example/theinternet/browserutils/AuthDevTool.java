package com.example.theinternet.browserutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AuthDevTool {

    WebDriver driver;

    public AuthDevTool(WebDriver driver) {
        this.driver = driver;
    }

    public void setAuthUserPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username = "admin"; //default
    private String password = "password"; //default

    public void devToolSetup() {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        String auth = username + ":" + password;

        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(auth.getBytes()));

        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", basicAuth);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
    }
}
