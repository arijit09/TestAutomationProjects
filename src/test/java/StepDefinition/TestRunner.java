package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Login.feature",
glue= {"StepDefinition"},
plugin = {"pretty","html:target/HtmlReports.html"})

//plugin = {"pretty","html:target/HtmlReports.html"}
//"json:target/cucumber.json"
public class TestRunner {

}
