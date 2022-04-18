package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= "src/test/resources/Features",
		glue= "StepDefinition",
		dryRun=false,
		monochrome=true,
		publish = true,
		plugin= {"rerun:target/Failed_Scenarios.txt",
				"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"junit:target/cucumber-reports/report.xml","pretty"}

		//for Generating Cucumber defaults reports
		//"pretty"
		//"usage"
		//"html:target/cucumber-reports/report.html"
		//"json:target/cucumber-reports/report.json"
		//"junit:target/cucumber-reports/report.xml"


		)
public class TestRunner {








	
	
	
	
}
