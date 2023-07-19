package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "junit:src/test/resources/features/htmlReport/cucumber.xml",
                "rerun:TestOutput/failed_scenario.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@US04Api",
        glue = {"stepdefs","hooks"},
        features = "src/test/resources/",
        dryRun = false
)
public class Runner {
}
