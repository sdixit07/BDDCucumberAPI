import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = "stepdefinitions",
        features = "./src/main/resources/Features/",
        tags = "@smoke")

public class TestRunner {
}
