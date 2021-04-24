package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "feature/development.feature",
		glue = {"stepdefinition"},
		monochrome = true,
//		dryRun = true,
		plugin = {"pretty","junit:target/JunitReports/report.xml",
					"json:target/Json/report.json",
					"html:target/html/report.html"}
		)
public class TestRunner {

}
