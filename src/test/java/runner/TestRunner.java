//saikiriti24396
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "StepDefinations",
    plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"} // Generate JSON report
)
public class TestRunner extends AbstractTestNGCucumberTests 
{
	
}