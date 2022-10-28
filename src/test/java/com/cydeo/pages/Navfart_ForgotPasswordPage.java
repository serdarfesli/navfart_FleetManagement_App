package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navfart_ForgotPasswordPage {
    public Navfart_ForgotPasswordPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//button")
    public WebElement requestButton;

    @FindBy(id = "prependedInput")
    public WebElement usernameOrMailInputBox;

    @FindBy(linkText = "« Return to Login")
    public WebElement returnToLoginLink;

    @FindBy(xpath = "//h2")
    public WebElement forgotPasswordHeader;



    @FindBy(xpath = "//div[@class='alert alert-warn']")
    public WebElement unableToSendWarningMessage;
}
