package API;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

public class AssertionsClass {

    SoftAssert softassert;

    public void checkResponseHttpStatusCode(Response response, int code) {
        response.then().
                assertThat().
                statusCode(code);
    }


    public void checkResponse_NotNull(Response response) {

        assert response != null;
    }

    public void checkContentType_expectJson(Response response) {
        response.then().
                assertThat().
                contentType("application/json");

    }

    public void checkjsonpath(JsonPath path, String value, String expected) {
        softassert = new SoftAssert();

        softassert.assertEquals(path.getString(value), expected);


    }


    public void printResponse(Response response) {
        System.out.println("The Response is :");
        response.prettyPrint();
    }
}

