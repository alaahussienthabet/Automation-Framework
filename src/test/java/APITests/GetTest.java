package APITests;

import API.AssertionsClass;
import API.APIActions;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class GetTest extends AssertionsClass {

    APIActions action;
    JsonPath path;

    @Test
    public void restassuredget() {
        HashMap<String, String> data =
                new HashMap<String, String>();
        data.put("page", "2");
        data.put("per_page", "5");
        action = new APIActions("https://reqres.in/");
        action.RequestWithParameters(data);
        Response response = action.response("api/users", Method.GET);
        response.then().log().all();
        checkResponseHttpStatusCode(response, 200);


    }


    @Test
    public void restassuredget_extract() {


        HashMap<String, String> data =
                new HashMap<String, String>();
        data.put("page", "2");
        data.put("per_page", "5");
        action = new APIActions("https://reqres.in/");
        action.RequestWithParameters(data);
        Response response = action.response("api/users", Method.GET);
        response.then().
                extract().response();
        path = response.jsonPath();

        checkjsonpath(path, "data[0].id", "1");
        checkjsonpath(path, "data[0].first_name", "George");

        checkResponseHttpStatusCode(response, 200);

        checkContentType_expectJson(response);

    }
}
