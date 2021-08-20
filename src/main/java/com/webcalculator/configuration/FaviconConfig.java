package com.webcalculator.configuration;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.util.Collections;
import java.util.List;

@Configuration
public class FaviconConfig {

    final ApplicationContext applicationContext;

    public FaviconConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SimpleUrlHandlerMapping myFaviconHandlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Integer.MIN_VALUE);
        mapping.setUrlMap(Collections.singletonMap("/favicon.ico",
                myFaviconRequestHandler()));
        return mapping;
    }
    @Bean
    protected ResourceHttpRequestHandler myFaviconRequestHandler()
    {
        ResourceHttpRequestHandler requestHandler =
                new ResourceHttpRequestHandler();
        requestHandler.setLocations(List.of(applicationContext.getResource("/")));
        requestHandler.setCacheSeconds(0);
        return requestHandler;
    }

}
