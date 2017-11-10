package com.au.example.service.model;

import com.au.example.rest.model.request.BaseReq;

public class LoginDto extends  BaseReq{

    private String username;

    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
