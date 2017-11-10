package com.au.example.service.mapper;

import com.au.example.repository.entity.User;
import com.au.example.rest.model.response.LoginResp;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
@Component
public class UserMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(LoginResp.class, User.class)
                .byDefault()
                .register();
    }


}

