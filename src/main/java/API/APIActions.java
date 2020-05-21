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

    public APIActions(String url) {

        baserequest = given().baseUri(url).and();

    }

    public RequestSpecification RequestWithParameters(HashMap<String, String> data) {

        request = baserequest.params(data);
        return request;

    }

    public RequestSpecification RequestWithPathParameters(HashMap<String, String> data) {

        request = baserequest.pathParams(data);
        return request;

    }

    public RequestSpecification RequestWithQuaryParameters(HashMap<String, String> data) {
        request = baserequest.queryParams(data);
        return request;

    }

    public RequestSpecification RequestWithQuaryParametersendBody(HashMap<String, String> data, JSONObject object, ContentType type) {

        request = RequestWithQuaryParameters(data).contentType(type)
                .body(object.toJSONString());
        return request;

    }

    public RequestSpecification RequestWithPathParametersendBody(HashMap<String, String> data, JSONObject object, ContentType type) {
        request = RequestWithPathParameters(data).contentType(type).
                body(object.toJSONString());
        return request;
    }

    public RequestSpecification RequestWithParametersendBody(HashMap<String, String> data, JSONObject object, ContentType type) {
        request = RequestWithParameters(data).contentType(type)
                .body(object.toJSONString());

        return request;
    }

    public Response response(String path, Method method) {
        response = request.when().request(method, path);

        return response;
    }

}

