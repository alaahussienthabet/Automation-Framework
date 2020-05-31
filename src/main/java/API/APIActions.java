package API;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class APIActions {

    RequestSpecification baserequest;
    RequestSpecification request;
    Response response;
    // base URL request
    public APIActions(String url) {

        baserequest = given().baseUri(url).and();

    }
    //send request with parameters
    public RequestSpecification requestWithParameters(HashMap<String, String> data) {

        request = baserequest.params(data);
        return request;

    }
    //send request with path parameters
    public RequestSpecification requestWithPathParameters(HashMap<String, String> data) {

        request = baserequest.pathParams(data);
        return request;

    }
    //send request with Query parameters
    public RequestSpecification requestWithQueryParameters(HashMap<String, String> data) {
        request = baserequest.queryParams(data);
        return request;

    }
    //send request with Query parameters, headers and body
    public RequestSpecification requestWithQueryParameterAndSendBody(HashMap<String, String> data, JSONObject object, ContentType type) {

        request = requestWithQueryParameters(data).contentType(type)
                .body(object.toJSONString());
        return request;

    }
    //send request with Path parameters, headers and body
    public RequestSpecification requestWithPathParameterAndSendBody(HashMap<String, String> data, JSONObject object, ContentType type) {
        request = requestWithPathParameters(data).contentType(type).
                body(object.toJSONString());
        return request;
    }
    //send request with parameters, headers and body
    public RequestSpecification requestWithParameterAndSendBody(HashMap<String, String> data, JSONObject object, ContentType type) {
        request = requestWithParameters(data).contentType(type)
                .body(object.toJSONString());

        return request;
    }
    //send method and caption response
    public Response response(String path, Method method) {
        response = request.when().request(method, path);

        return response;
    }

}

