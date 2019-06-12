package com.homeChallengeTests;

import com.enums.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.assertTrue;

public class TestsHelper extends TestsManager {

    /**
     * This method first will wait to element id that call 'finish' and after that will check if message present
     * @param message
     */
    protected void verifyMessage(String message) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(webPage.loadingFinish));
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean isAjaxExist = isCanFindAjax(ajaxWebPage.iframeResult, Text.IFRAME_RESULT.getText(), ajaxWebPage.ajaxDemo);
        if(!isAjaxExist)
            assertTrue(isMessagePresent(message));
    }

    /**
     * This method check if message exist in the page - return true if exist
     * @param message
     * @return
     */
    private boolean isMessagePresent(String message) {
        try{
            boolean isPresent = driver.getPageSource().contains(message);
            return isPresent;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This method first check if there is iframe
     * If true --> find By.id = demo --> click on button and wait till 'AJAX' message appear
     * @param locatorA
     * @param iframe
     * @param locatorB
     * @return
     */
    protected boolean isCanFindAjax(By locatorA, String iframe, By locatorB) {
        boolean isIframeExist = driver.findElements(locatorA).size() > 0;
        if (isIframeExist) {
            driver.switchTo().frame(iframe);
            WebElement demo = driver.findElement(locatorB);
            demo.findElement(ajaxWebPage.changeContentBtn).click();
            wait.until(ExpectedConditions.textToBePresentInElement(demo, Text.AJAX.getText()));
            String demoContent = demo.getText().trim();
            System.out.println("demoContent: " + demoContent);
            driver.switchTo().defaultContent();
            return true;
        }
        return false;
    }
}
