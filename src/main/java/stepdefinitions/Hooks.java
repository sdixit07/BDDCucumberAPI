package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;
    public static Properties properties;

    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            properties = new Properties();
            properties.load(new FileInputStream("./src/main/java/config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @AfterStep
    public void addScreenshot(Scenario scenario){
        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

    @After
    public void closeBrowser(){
        driver.close();
    }
}
