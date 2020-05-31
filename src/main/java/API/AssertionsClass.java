package API;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

public class AssertionsClass {

    SoftAssert softassert;
    // validate status code of response
    public void checkResponseHttpStatusCode(Response response, int code) {
        response.then().
                assertThat().
                statusCode(code);
    }

    // validate of response is null or not
    public void checkResponse_NotNull(Response response) {

        assert response != null;
    }
    // validate the content type of response
    public void checkContentType_expectJson(Response response) {
        response.then().
                assertThat().
                contentType("application/json");

    }
    // validate the json path of response
    public void checkJsonPath(JsonPath path, String value, String expected) {
        softassert = new SoftAssert();

        softassert.assertEquals(path.getString(value), expected);


    }

    // print response
    public void printResponse(Response response) {
        System.out.println("The Response is :");
        response.prettyPrint();
    }
}

