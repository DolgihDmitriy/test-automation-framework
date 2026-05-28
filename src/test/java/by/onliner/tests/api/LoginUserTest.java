package by.onliner.tests.api;

import by.onliner.api.endpoint.LoginUser;
import by.onliner.api.pojo.LoginResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginUserTest {
    private static final String EMAIL = "navis1mplegod@mail.ru";
    private static final String PASSWORD = "**********";
    private static final String WRONG_PASSWORD = "wrongPassword";
    @Test
    public void loginWithInvalidPassword() {
        Response response = LoginUser.loginUser(EMAIL,WRONG_PASSWORD);
        System.out.println(response.asPrettyString());
        assertThat(response.getStatusCode()).isEqualTo(400);

        LoginResponse lr = response.as(LoginResponse.class);
        assertThat(lr.getErrors().getFirst().getKey()).isEqualTo("invalid_login_or_password");

    }

    @Test
    public void loginWithValidPassword() {
        Response response = LoginUser.loginUser(EMAIL,PASSWORD);
        System.out.println(response.asPrettyString());
        assertThat(response.getStatusCode()).isEqualTo(200);

        LoginResponse lr = response.as(LoginResponse.class);
        assertThat(lr.getAccessToken()).isNotNull();
    }