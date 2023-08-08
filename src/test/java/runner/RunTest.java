package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "StepDef",
        tags = "@Registration",
        plugin = {"pretty", "html:target/RegressionRegistrationReport.html"}

)
public class RunTest {
}
