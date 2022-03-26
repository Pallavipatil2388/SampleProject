package myproject.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:features",
		glue ="myproject.stepdef",
		tags = "@footerlink",
		plugin = {
				"pretty",
				"html:target/html/htmlreport.html",
				"json:target/json/file.json",
		},
		monochrome = true,
		publish = true,
		dryRun = false
		)

public class testrunner {

}

