package com.airbnb.cucumber_runner;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com.airbnb/features",
        glue = {"airbnb"},
//        set up tags for tasks
//        tags = {"@any"},
        plugin = {
                "pretty",
                "json:build/cucumber-report/cucumber.json",
                "html:build/cucumber-report/cucumber.html",
                "junit:build/cucumber-report/cucumber.xml"}
)

public class CucumberRunner {
}
