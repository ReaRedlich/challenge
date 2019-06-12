package com.homeChallengeTests;

import com.webManager.AjaxWebPage;
import com.webManager.ChallengeWebPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;

public class TestsManager {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ChallengeWebPage webPage;
    protected AjaxWebPage ajaxWebPage;
    private final String URL = "http://the-internet.herokuapp.com/dynamic_loading/2";

    /**
     * ChromeDriver version - 75.0.3770.8
     * This method open the chromeDriver and goes to web page
     * The annotated @BeforeMethod will be run before all the test methods in the current class have been run.
     */
    @BeforeMethod
    public void initTest() {
        System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.get(URL);
        webPage = new ChallengeWebPage(driver);
        ajaxWebPage = new AjaxWebPage(driver);
    }

    /**
     * The annotated @AfterMethod will be run after each test method
     * The method will check if test failed --> if he failed he take screenshot and highlight in red the message that incorrect
     * @param iTestResult
     * @throws Exception
     */
    @AfterMethod
    public void screenshotOnFailed(ITestResult iTestResult) throws Exception {
        if(ITestResult.FAILURE == iTestResult.getStatus()) {
            System.out.println("TEST FAILED");
            highlightWrongMessage();
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(".\\Files\\screenshot_" + System.currentTimeMillis() + ".png");
            FileUtils.copyFile(source, destination);
        }
        else
            System.out.println("TEST PASSED");
        tearDown();
    }

    /**
     * If test failed this methods will highlight in border red the wrong message
     */
    private void highlightWrongMessage() {
        WebElement webElement = driver.findElement(webPage.loadingFinish);
        WebElement textContent = webElement.findElement(webPage.messageContent);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: red;');", textContent);
    }

    /**
     * This method will close the chromeDriver
     */
    public void tearDown() {
        driver.quit();
    }
}
