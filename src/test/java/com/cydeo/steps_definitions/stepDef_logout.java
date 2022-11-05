package com.cydeo.steps_definitions;

import com.cydeo.pages.Navfart_HomePage;
import com.cydeo.pages.Navfart_LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

public class stepDef_logout {
Navfart_LoginPage navfart_loginPage = new Navfart_LoginPage();
Navfart_HomePage navfart_homePage = new Navfart_HomePage();


   @Given("user logins successfully as {string} and is on the homePage")
   public void userIsAlreadyOnTheHomePageWith (String userProfile) {
      navfart_loginPage.login(userProfile);
   }


   @Then("user lands on login page")
   public void userLandsOnLoginPage() {
      Assert.assertTrue(Driver.getDriver().getTitle().equals("Login"));
   }

   @When("user logs out successfully")
   public void userLogsOutSuccesfully() {
      navfart_homePage.logout();
   }

   @And("user clicks navigate back button")
   public void userClicksNavigateBackButton() {
      Driver.getDriver().navigate().back();
      BrowserUtils.sleep(3);
   }

   @And("user still stays on the login page")
   public void userStillStaysOnTheLoginPage() {
      Assert.assertTrue(Driver.getDriver().getTitle().equals("Login"));
   }

   @When("user closes the open tab-tabs")
   public void userClosesTheAllTheTabsWindows() {
      Driver.closeDriver();
   }

   @And("user navigates to app's home page")
   public void userNavigatesToAppSHomePage() {
      Driver.getDriver().get("https://qa.navfort.com/");
   }

   @When("user opens the second tab")
   public void userOpensANewTab() {
      ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()");
      ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
      Driver.getDriver().switchTo().window(tabs.get(1));
   }

   @When("user is away from keyboard for three minutes")
   public void userIsAwayFromKeyboardForThreeMinutes() {
      BrowserUtils.sleep(180);
   }

   @And("user navigates to the login page")
   public void userNavigatesToTheLoginPage() {
      Driver.getDriver().get(ConfigurationReader.getProperty("loginPageUrl"));
   }

   @And("user navigates to the home page while on the second tab")
   public void userNavigatesToTheLoginPageWhileOnTheSecondTab() {
      Driver.getDriver().get(ConfigurationReader.getProperty("loginPageUrl"));
   }
}
