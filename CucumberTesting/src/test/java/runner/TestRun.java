package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features = "src/main/resources/featureFunctions",
glue={"defintions"}, plugin={"pretty"},monochrome = true)
public class TestRun {

}
