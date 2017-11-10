package com.au.example.rest.controller.handler;

import com.au.example.exception.TemplateException;
import com.au.example.rest.model.response.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestResponseExceptionHandler.class);

    @Value("${apps.error.code.header.key}")
    private String errorCodeHeaderKey;

    @Autowired
    Tracer tracer;


    @ExceptionHandler(TemplateException.class)
    public ResponseEntity<RestResponse> handleTemplateException(HttpServletRequest request, TemplateException templateException) {
        String errors = Arrays.stream(templateException.getApiErrors()).collect(Collectors.joining(","));
        logger.error(errors);
        RestResponse response = new RestResponse(tracer.getCurrentSpan().getTraceId(), templateException.getHttpStatusCode(), errors);
        return ResponseEntity
                .status(templateException.getHttpStatusCode())
                .header(errorCodeHeaderKey, templateException.getErrorCode())
                .body(response);
    }
}
