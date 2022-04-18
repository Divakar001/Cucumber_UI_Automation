package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= "@target/Failed_Scenarios.txt",
		glue= "StepDefinition",
		dryRun=false,
		monochrome=true
	
		
		)
public class rerunner {

}
