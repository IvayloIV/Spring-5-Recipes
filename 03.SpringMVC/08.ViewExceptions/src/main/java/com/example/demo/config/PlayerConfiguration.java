package com.example.demo.config;

import com.example.demo.exceptions.PlayerNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Properties;

@Configuration
@ComponentScan("com.example.demo")
public class PlayerConfiguration implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//        resolvers.add(handlerExceptionResolver());
//    }
//
//    @Bean
//    public HandlerExceptionResolver handlerExceptionResolver() {
//        Properties properties = new Properties();
//        properties.setProperty(PlayerNotFoundException.class.getName(), "playerNotFound");
//
//        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
//        exceptionResolver.setExceptionMappings(properties);
//        exceptionResolver.setDefaultErrorView("error");
//        return exceptionResolver;
//    }
}
