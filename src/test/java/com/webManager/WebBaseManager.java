package com.webManager;

import org.openqa.selenium.WebDriver;

public class WebBaseManager {
    protected WebDriver driver;

    public WebBaseManager(WebDriver driver) {
        this.driver = driver;
    }
}
