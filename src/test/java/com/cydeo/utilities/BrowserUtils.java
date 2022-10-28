package com.cydeo.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    public static void waitUntilVisibiltyOf(WebElement webElement){
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilInvisibiltyOf(WebElement webElement){
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }
}
