package APITests;

import API.AssertionsClass;
import API.APIActions;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;


public class PostTest extends AssertionsClass {
    APIActions action;
    JsonPath path;


    @DataProvider(name = "testData1")
    public static Object[][] testData() {
        return new Object[][]{
                {"alaa", "tester"},
                {"nehal", "tester"},
                {"rahma", "tester"}
        };
    }

    @Test(dataProvider = "testData1")
    public void RestAssuredPostRequest(String name, String job) {
        JSONObject object = new JSONObject();

        object.put("name", name);
        object.put("job", job);

        HashMap<String,String> data=
                new HashMap<String,String>();
        data.put("id","2");

        action= new APIActions("https://reqres.in/") ;
        action.requestWithQueryParameterAndSendBody(data,object,ContentType.JSON);
        Response response = action.response("api/users", Method.POST);

        response.then().log().body();
        checkResponseHttpStatusCode(response,200);




    }

    @Test(dataProvider = "testData1")
    public void RestAssuredPostRequest_Extract(String name, String job) {
        JSONObject object = new JSONObject();

        object.put("name", name);
        object.put("job", job);

        HashMap<String,String> data=
                new HashMap<String,String>();
        data.put("id","2");

        action= new APIActions("https://reqres.in/") ;
        action.requestWithQueryParameterAndSendBody(data,object, ContentType.JSON);
        Response response = action.response("api/users", Method.GET);

        response.then().
                extract().response();
        path = response.jsonPath();

        checkResponseHttpStatusCode(response,200);
}
}
