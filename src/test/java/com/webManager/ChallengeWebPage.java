package com.webManager;

import org.openqa.selenium.*;

public class ChallengeWebPage extends WebBaseManager {
    private By startButton = By.id("start");
    public By loadingFinish = By.id("finish");
    private By clickOnStartBtn = By.tagName("button");
    public By messageContent = By.tagName("h4");

    public ChallengeWebPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnButton() {
        WebElement webElement = driver.findElement(startButton);
        webElement.findElement(clickOnStartBtn).click();
    }
}

