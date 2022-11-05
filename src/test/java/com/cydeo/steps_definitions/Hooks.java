package com.cydeo.steps_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
   @After
   public void tearDown(Scenario scenario) {
      if (scenario.isFailed()) {
         byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenShot, "png", scenario.getName());
      }
      Driver.closeDriver();
   }
}
