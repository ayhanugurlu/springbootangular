package com.au.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 15.09.2017.
 */
@Service
public class CultureServiceImpl implements CultureService {

    @Override
    public Map<String, String> getCultureMap(String culture) {
        Map<String,String> cultureMap = new HashMap<String, String>();
        if(culture.equals("en")){
            cultureMap.put("login_username","username");
        }else{
            cultureMap.put("login_username","kulanici adi");
        }


        return cultureMap;
    }
}
