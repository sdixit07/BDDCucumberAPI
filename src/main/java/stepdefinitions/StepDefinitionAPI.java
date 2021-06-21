package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import utils.Helper;

import java.io.IOException;

public class StepDefinitionAPI {
    public static String BASE_URL = "http://demowebshop.tricentis.com";
    RequestSpecification request;
    Response response;
    String token;

    @Given("I prepare the Endpoint")
    public void iPrepareTheEndpoint() {
        request = Helper.initiateRequest();
    }

    @When("I set the content type as {string}")
    public void iSetTheContentType(String contentType) {
        Helper.setContentTypeHeader(request, contentType);
    }

    @And("I enter the credentials as {string} and {string}")
    public void iEnterTheCredentialsAsAnd(String usr, String pwd) {
        request.multiPart("Email", usr)
                .multiPart("Password", pwd);
    }

    @And("I hit the login API POST request")
    public void iHitTheLoginAPIPOSTRequest() {
        response = request.post();
    }

    @Then("I fetch the access token")
    public void iFetchTheAccessToken() {
        token = response.getCookie("Nop.customer");
    }

    @And("I verify that the login is successful")
    public void iVerifyThatTheLoginIsSuccessful() {
        Assert.assertEquals(200,response.getStatusCode());
    }


    @When("I set the token")
    public void iSetTheToken() {
        request = Helper.initiateRequest();
        request.cookies("Nop.customer",token);
    }

    @And("I hit the Products Page GET API request")
    public void iHitTheProductsPageGETAPIRequest() {
        response = request.get(BASE_URL);
    }

    @Then("I verify that the Products are fetched successfully")
    public void iVerifyThatTheProductsAreFetchedSuccessfully() throws IOException {
        Document doc = Jsoup.connect(BASE_URL).get();
//        System.out.println(response.body().prettyPrint());
        Elements elements = doc.body().getElementsByAttributeValue("href","/books");
        System.out.println(elements.text());
        Assert.assertEquals("Books", elements.get(0).text());
    }
}
