package com.au.example.rest.controller;

import com.au.example.exception.InvalidUserNameOrPassword;
import com.au.example.rest.model.request.LoginReq;
import com.au.example.rest.model.response.LoginResp;
import com.au.example.rest.model.response.RestResponse;
import com.au.example.service.UserService;
import com.au.example.service.model.LoginDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 12.09.2017.
 */
@RestController
public class UserController {


    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    @Qualifier("userControllerMapper")
    MapperFacade mapperFacade;

    @Autowired
    Tracer tracer;


    @ApiOperation(value = "login user ",
            notes = "login user into the template application.<br/>")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    RestResponse<LoginResp> loginUsers(@ApiParam(value = "username and password") @RequestBody LoginReq loginRequest) throws InvalidUserNameOrPassword {
        logger.debug("loginUsers method start", tracer.getCurrentSpan().getTraceId());
        LoginDto loginDto = mapperFacade.map(loginRequest, LoginDto.class);
        LoginResp loginResp = userService.login(loginDto);
        return new RestResponse<LoginResp>(tracer.getCurrentSpan().getTraceId(), HttpStatus.OK.value(), loginResp, "");
    }

}
