package com.airbnb.cucumber_runner;
import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import courgette.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.FEATURE,
        showTestOutput = true,
        reportTargetDir = "build/parallel",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "airbnb",
//setup tasks
//                tags = {"@any1 or @any2"},
                plugin = {
                        "pretty",
                        "json:build/cucumber-report/cucumber.json",
                        "html:build/cucumber-report/cucumber.html",
                        "junit:build/cucumber-report/cucumber.xml"}
        )
)

public class CourgetteRunner {

}
