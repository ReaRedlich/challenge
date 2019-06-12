package com.webManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AjaxWebPage extends WebBaseManager {
    public By iframeResult = By.id("iframeResult");
    public By ajaxDemo = By.id("demo");
    public By changeContentBtn = By.tagName("button");

    public AjaxWebPage(WebDriver driver) {
        super(driver);
    }
}
