package Runner;

import FacebookTests.BaseClass;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/java/Feature"},glue = {"Steps"},plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends BaseClass {


}
