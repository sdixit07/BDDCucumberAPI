import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:Report/Cucumber.html"},
        glue = "stepdefinitions",
        features = "./src/main/resources/Features/",
        tags = "UI")

public class TestRunner {
}
    