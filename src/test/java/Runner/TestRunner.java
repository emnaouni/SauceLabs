package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/feature",
glue = {"StepDefinition"},
plugin = {"pretty" , "html:target\\cucumber\\report.html"
},
tags =("@Checkout") )

public class TestRunner {

}
