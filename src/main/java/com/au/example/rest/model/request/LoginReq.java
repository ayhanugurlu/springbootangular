package com.au.example.rest.model.request;

import io.swagger.annotations.ApiModelProperty;

public class LoginReq extends  BaseReq{

    private String username;

    private String password;


    @ApiModelProperty(notes = "template username", required = true, example = "template")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ApiModelProperty(notes = "tempalate password", required = true, example = "pass")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
