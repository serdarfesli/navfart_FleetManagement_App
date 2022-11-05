package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navfart_HomePage {
    public Navfart_HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement pageHeader;

    @FindBy(xpath = "//a[@href='javascript: void(0);']")
    public WebElement usernameDropdown;

    @FindBy(xpath = "//a[@href='/user/logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "//div[@class='bar']")
    public WebElement loadingBar;

    public void logout(){
        usernameDropdown.click();
        logoutLink.click();
    }
}
