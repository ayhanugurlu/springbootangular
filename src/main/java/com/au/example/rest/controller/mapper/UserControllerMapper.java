package com.au.example.rest.controller.mapper;

import com.au.example.rest.model.request.LoginReq;
import com.au.example.service.model.LoginDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
@Component
public class UserControllerMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(LoginDto.class, LoginReq.class)
                .byDefault()
                .register();
    }


}

