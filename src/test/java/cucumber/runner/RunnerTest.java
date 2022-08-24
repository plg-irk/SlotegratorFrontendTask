package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"/cucumber/steps", "/cucumber/hooks"})

public class RunnerTest extends AbstractTestNGCucumberTests {
}
