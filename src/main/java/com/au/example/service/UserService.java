package com.au.example.service;

import com.au.example.exception.InvalidUserNameOrPassword;
import com.au.example.rest.model.request.LoginReq;
import com.au.example.rest.model.response.LoginResp;
import com.au.example.service.model.LoginDto;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
public interface UserService {

    LoginResp login(LoginDto loginDto) throws InvalidUserNameOrPassword;

}
