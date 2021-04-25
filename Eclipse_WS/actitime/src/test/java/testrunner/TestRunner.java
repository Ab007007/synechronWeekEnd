package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "feature",
		glue = {"stepdefinition"},
		monochrome = true,
		//tags = "@smoke",
		//tags = "@smoke or @dt",
		//tags = "@smoke and @regression",
//		tags = "@smoke and not @regression",
		tags = "@pom",
//		dryRun = true,
		plugin = {"pretty","junit:target/JunitReports/report.xml",
					"json:target/Json/report.json",
					"html:target/html/report.html"}
		)
public class TestRunner {

}
