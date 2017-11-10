package com.au.example.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
public class InvalidUserNameOrPassword extends TemplateException{


    private String username;

    public InvalidUserNameOrPassword(String username) {
        this.username = username;
    }

    @Override
    public int getHttpStatusCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }

    @Override
    public String getErrorCode() {
        return InvalidUserNameOrPassword.class.getSimpleName();
    }

    @Override
    public String[] getApiErrors() {
        return new String[0];
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
