package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navfart_LoginPage {
    public Navfart_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInputBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInputBox;


    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotYourPasswordLink;

    @FindBy(id = "_submit")
    public WebElement loginButton;


    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidUsernameOrPasswordErrorMessage;

    public void login(String userProfile) {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPageUrl"));
        if (userProfile.equalsIgnoreCase("driver")) {
            usernameInputBox.sendKeys("user1");
        } else if (userProfile.equalsIgnoreCase("storeManager")) {
            usernameInputBox.sendKeys("storemanager51");
        } else {
            usernameInputBox.sendKeys("salesmanager101");
        }
        passwordInputBox.sendKeys("UserUser123");
        loginButton.click();
    }
}
