package by.onliner.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public static RequestSpecification loginRequest() {
        return new RequestSpecBuilder()
                .setBaseUri("https://www.onliner.by/")
                .setBasePath("sdapi/user.api/login")
                .setContentType(ContentType.JSON)
                .build();
    }
}
