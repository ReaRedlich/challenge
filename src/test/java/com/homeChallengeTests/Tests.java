package com.homeChallengeTests;

import com.enums.Text;
import org.testng.annotations.Test;

public class Tests extends TestsHelper {

    @Test
    public void verifyHelloWorld() {
        webPage.clickOnButton();
        verifyMessage(Text.HELLO_WORLD.getText());
    }

    @Test
    public void verifyHeyWorld() {
        webPage.clickOnButton();
        verifyMessage(Text.HEY_WORLD.getText());
    }
}

