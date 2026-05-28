package by.onliner.api;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginUserService {

    private final String URL_USER_LOGIN = "https://www.onliner.by/sdapi/user.api/login";
    private Map<String, String> headers;
    private String body;
    private Response response;

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void doRequest() {
        response = given()
                .headers(headers)
                .body(body)
                .when()
                .post(URL_USER_LOGIN);
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getBody() {
        return response.getBody().asPrettyString();
    }
}
