package com.au.example.rest.model.response;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
public class LoginResp {

    private String firstName;

    private String lastName;

    private String token;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
