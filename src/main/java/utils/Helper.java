package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import stepdefinitions.StepDefinitionAPI;
import org.openqa.selenium.WebElement;


public class Helper {
    public static RequestSpecification initiateRequest(){
        RestAssured.baseURI = StepDefinitionAPI.BASE_URL;
            RequestSpecification request = RestAssured.given();
        return request;
    }

    public static RequestSpecification setContentTypeHeader(RequestSpecification request,String contentType){
        return request.contentType(contentType);
    }

    public static void enterTextInTheTextBox(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
}
