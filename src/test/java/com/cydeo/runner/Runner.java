package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {
        "html:target/cucumber-report.html",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt",
        "junit:target/junit/junit-report.xml",
        "me.jvt.cucumber.report.PrettyReports:target/cucumber"
},
        features = "src/test/resources/features",
        glue = "com/cydeo/steps_definitions",
        tags = "@NVF-694",
        dryRun = false
)
public class Runner {
}
