package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", //path for feature files
        glue = "steps",      //path for  java class with steps
        tags = "@HR-20",
        dryRun = true
)

public class Runner {

}
