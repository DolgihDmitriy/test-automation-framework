package by.onliner.api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginInput {
    @JsonProperty("login")
    private String userEmail;
    @JsonProperty("password")
    private String userPassword;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
