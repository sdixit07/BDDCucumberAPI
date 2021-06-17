package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import stepdefinitions.MyStepdefs;

public class Helper {
    public static RequestSpecification initiateRequest(){
        RestAssured.baseURI = MyStepdefs.BASE_URL;
            RequestSpecification request = RestAssured.given();
        return request;
    }

    public static RequestSpecification setContentTypeHeader(RequestSpecification request,String contentType){
        return request.contentType(contentType);
    }
}
