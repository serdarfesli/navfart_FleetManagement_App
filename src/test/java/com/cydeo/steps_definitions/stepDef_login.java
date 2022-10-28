package com.cydeo.steps_definitions;

import com.cydeo.pages.Navfart_ForgotPasswordPage;
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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class stepDef_login {
   Navfart_LoginPage navfart_loginPage = new Navfart_LoginPage();
   Navfart_HomePage navfart_homePage= new Navfart_HomePage();
   Navfart_ForgotPasswordPage navfart_forgotPasswordPage= new Navfart_ForgotPasswordPage();


   @Given("user navigates to the login page")
   public void user_is_already_on_the_login_page() {
      Driver.getDriver().get(ConfigurationReader.getProperty("loginPageUrl"));
   }

   @When("user enters username as {string} and password as {string}")
   public void user_enters_valid_username_as_and_password_as(String username, String password) {
      navfart_loginPage.usernameInputBox.sendKeys(username);
      navfart_loginPage.passwordInputBox.sendKeys(password);

   }

   @When("user clicks login button")
   public void user_clicks_login_button() {
      navfart_loginPage.loginButton.click();
   }

   @Then("user lands on {string}")
   public void user_lands_on(String header) {
      String expectedHeader=header;
      String actualHeader=navfart_homePage.pageHeader.getText();
      Assert.assertEquals(expectedHeader,actualHeader);
   }

   @Then("user see {string} message")
   public void userSeeMessage(String errorMessage) {

      String expectedErrorMessage = errorMessage;
      String actualErrorMessage = navfart_loginPage.invalidUsernameOrPasswordErrorMessage.getText();
      Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

   }



   @Then("user see {string} message from {string}")
   public void userSeeMessageFrom(String expectedValidationMessage, String validationMessageAppearingField) {
      if (validationMessageAppearingField.equals("password")){
         String expected=expectedValidationMessage;
         String actual=navfart_loginPage.passwordInputBox.getAttribute("validationMessage");
         System.out.println("actual = " + actual);
         Assert.assertEquals(expected,actual);
      } else {
         String expected=expectedValidationMessage;
         String actual=navfart_loginPage.usernameInputBox.getAttribute("validationMessage");
         System.out.println("actual = " + actual);
         Assert.assertEquals(expected,actual);
      }



   }

   @When("user types in password field")
   public void userTypesInPasswordField() {
      navfart_loginPage.passwordInputBox.sendKeys("abc");

   }

   @Then("user see bullet signs while typing")
   public void userSeeBulletSignsWhileTyping() {
      Assert.assertTrue(navfart_loginPage.passwordInputBox.getAttribute("type").equals("password"));
   }

   @When("user clicks ‘Forgot Password’ link")
   public void userClicksForgotPasswordLink() {
      navfart_loginPage.forgotYourPasswordLink.click();
   }

   @Then("user lands on ‘Forgot Password’ page")
   public void userLandsOnForgotPasswordPage() {
      String expectedPageTitle="Forgot Password";
      String actualPageTitle=Driver.getDriver().getTitle();
      Assert.assertEquals(expectedPageTitle,actualPageTitle);

   }

   @When("user enters his {string} into username-email inputBox")
   public void userEntersHisUserIntoUsernameEmailInputBox(String username) {
      navfart_forgotPasswordPage.usernameOrMailInputBox.sendKeys(username);
   }

   @And("user click request button")
   public void userClickRequestButton() {
      navfart_forgotPasswordPage.requestButton.click();
   }

   @Then("user gets successfully changed message.")
   public void userGetsSuccessfullyChabgedMessage() {
      Assert.assertTrue(!navfart_forgotPasswordPage.unableToSendWarningMessage.isDisplayed());
   }

   @When("user clicks remember_me_on_this_computer checkbox")
   public void userClicksRemember_me_on_this_computerCheckbox() {
      navfart_loginPage.rememberMeCheckBox.click();
   }

   @And("user enters {string} as username and {string} as password")
   public void userEntersAsUsernameAndAsPassword(String username, String password) {
      navfart_loginPage.usernameInputBox.sendKeys(username);
      navfart_loginPage.passwordInputBox.sendKeys(password);
   }

   @And("user clicks username dropdown menu on the upright")
   public void userClicksUsernameDropdownMenuOnTheUpright() {
      BrowserUtils.waitUntilInvisibiltyOf(navfart_homePage.loadingBar);
      navfart_homePage.usernameDropdown.click();
   }

   @And("user clicks log out button")
   public void userClicksLogOutButton() {
      navfart_homePage.logoutLink.click();
   }

   @Then("user sees username and password inputboxes are already filled with credentials {string} and {string}")
   public void userSeesUsernamaAndPasswordInputboxesAreAlreadyFilledWithCredentials(String username,String password) {
      String expectedUsername=username;
      String actualUsername=navfart_loginPage.usernameInputBox.getAttribute("value");

      Assert.assertEquals(expectedUsername,actualUsername);

      String expectedPassword=password;
      String actualPassword=navfart_loginPage.passwordInputBox.getAttribute("value");
      Assert.assertEquals(expectedPassword,actualPassword);
   }

   @And("user closes the tab-window")
   public void userClosesTheTabWindow() {
      Driver.closeDriver();
   }

   @When("user enters his {string} and {string} switching by Enter key")
   public void userEntersHisIntoUsernameInputbox(String username,String password) {
      navfart_loginPage.usernameInputBox.sendKeys(username + Keys.ENTER+password);
   }


   @And("user hits enter key in the password field")
   public void userClicksEnterKeyWhileTheCursorIsInThePasswordInputBox() {
      navfart_loginPage.passwordInputBox.sendKeys(Keys.ENTER);
   }

   @When("user hits Enter key in the username field")
   public void usernameFieldIsEmptyUserHitsEnterKey() {
      navfart_loginPage.usernameInputBox.sendKeys(Keys.ENTER);
   }

   @Then("username field throws {string} message")
   public void usernameFieldThrowsMessage(String expectedValidationMessage) {
      String expected=expectedValidationMessage;
      String actual=navfart_loginPage.usernameInputBox.getAttribute("validationMessage");
      System.out.println("actual = " + actual);
      Assert.assertEquals(expected,actual);
   }

   @Given("username field is empty")
   public void usernameFieldIsEmpty() {
      Assert.assertTrue(navfart_loginPage.usernameInputBox.getAttribute("value").equals(""));
   }

   @When("user enters {string} as username and hits Enter")
   public void userEntersUsernameAndHitsEnter(String username) {
      navfart_loginPage.usernameInputBox.sendKeys(username + Keys.ENTER);
   }



   @Then("password field throws {string} message")
   public void passwordFieldThrowsMessage(String expectedValidationMessage) {
      String expected=expectedValidationMessage;
      String actual=navfart_loginPage.passwordInputBox.getAttribute("validationMessage");
      System.out.println("actual = " + actual);
      Assert.assertEquals(expected,actual);
   }
}
