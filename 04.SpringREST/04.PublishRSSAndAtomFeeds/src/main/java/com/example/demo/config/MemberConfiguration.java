package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.example.demo")
public class MemberConfiguration implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setOrder(0);
        viewResolver.setBasename("feed");
        return viewResolver;
    }
}
