package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/mouli/SeleniumCucumber/src/test/resources/Feature/",
        glue = "stepDefinitions",
        plugin = {"pretty",
                "html:target/cucumber-report-html/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        }
)

public class Testrunner {
}
