package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.Constants;

import static org.junit.Assert.assertTrue;

public class StepDefinitionUI {
    LoginPage loginPage = new LoginPage();

    @Given("I enter the Application url")
    public void iEnterTheApplicationUrl() {
        Hooks.driver.get(Constants.APP_URL);
    }

    @When("I click on the Login link")
    public void iClickOnTheLoginLink() {
        loginPage.clickOnTheLoginLink();
    }

    @And("I enter the username")
    public void iEnterTheUsernameAs() {
        loginPage.enterUsername();
    }

    @And("I enter the password")
    public void iEnterThePasswordAs() {
        loginPage.enterPassword();
    }

    @And("I click on the Log in button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I login to the application successfully")
    public void iLoginToTheApplicationSuccessfully() {

        assertTrue(loginPage.isTopMenuDisplayed());
    }
}
