package com.au.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 12.09.2017.
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan

public class TemplateApplication {

    public static void main(String[] args) {

            SpringApplication.run(TemplateApplication.class, args);


    }

}
