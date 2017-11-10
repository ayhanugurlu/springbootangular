package com.au.example.service;

import com.au.example.repository.entity.User;
import com.au.example.exception.InvalidUserNameOrPassword;
import com.au.example.repository.UserRepository;
import com.au.example.rest.model.request.LoginReq;
import com.au.example.rest.model.response.LoginResp;
import com.au.example.service.model.LoginDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    @Qualifier("userMapper")
    MapperFacade mapperFacade;

    public LoginResp login(LoginDto loginDto) throws InvalidUserNameOrPassword {
        LoginResp loginResp = null;
        User user = userRepository.findByUserName(loginDto.getUsername());
        if(user != null && user.getPassword().equals(loginDto.getPassword())){
            loginResp = mapperFacade.map(user, LoginResp.class);
            return loginResp;
        }
        throw  new InvalidUserNameOrPassword(loginDto.getUsername());

    }
}
