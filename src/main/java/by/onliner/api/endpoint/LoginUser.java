package by.onliner.api.endpoint;

import by.onliner.api.pojo.LoginInput;
import by.onliner.api.utils.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class LoginUser {
    public static Response loginUser(String email, String password) {
        //RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://www.onliner.by/").setContentType(ContentType.JSON).build();
        LoginInput input = new LoginInput();
        input.setUserEmail(email);
        input.setUserPassword(password);
        //ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        RequestSpecification reqSpec = given().spec(RequestSpec.loginRequest()).body(input);
        return reqSpec.post();
//                .then().extract().response();
    }
}
