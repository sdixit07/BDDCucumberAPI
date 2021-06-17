import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import static io.restassured.RestAssured.given;

public class APITest {

    public static void main(String[] args) throws JSONException {
        RestAssured.baseURI = "https://bookstore.toolsqa.com/";
        Response response = given().accept("application/json").when().get("BookStore/v1/Books")
                .then().extract().response();

//        System.out.println(response.body().prettyPrint());
        JSONObject jsonObject = new JSONObject(response.body().asPrettyString());
        System.out.println(jsonObject);
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");
        System.out.println(jsonArray);

        for(int i=0; i < jsonArray.length(); i++){
            jsonObject = (JSONObject) jsonArray.get(i);
            if(jsonObject.get("author").equals("Addy Osmani")){
                break;
            }
        }

        System.out.println(jsonObject);
        System.out.println(jsonObject.get("title"));
    }
}
