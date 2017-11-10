package com.au.example.rest.controller;

import com.au.example.rest.model.response.RestResponse;
import com.au.example.service.CultureService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 15.09.2017.
 */
@RestController
public class CultureController {

    private static Logger logger = LoggerFactory.getLogger(CultureController.class);

    @Autowired
    CultureService cultureService;

    @Autowired
    Tracer tracer;


    @ApiOperation(value = "get culture map ",
            notes = "gettıng applıcations culture map.<br/>")
    @RequestMapping(value = "/culture/{culture}", method = RequestMethod.GET)
    public
    @ResponseBody
    RestResponse<String> getCultureMap(@PathVariable String culture) {
        logger.debug("loginUsers method start", tracer.getCurrentSpan().getTraceId());


        Map<String, String> languageMap = cultureService.getCultureMap(culture);

        ObjectMapper mapper = new ObjectMapper();
        String languageAsJson = null;
        try {
            languageAsJson = mapper.writeValueAsString(languageMap);
        } catch (JsonProcessingException e) {
            logger.error("Object cannot be converted to JSON string: Object [{}], Error [{}]", languageMap.getClass(), e);
        }
        return new RestResponse<>(tracer.getCurrentSpan().getTraceId(), HttpStatus.OK.value(), languageAsJson, "");
    }


}
