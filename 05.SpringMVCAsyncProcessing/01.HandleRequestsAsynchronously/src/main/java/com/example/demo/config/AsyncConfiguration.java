package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.example.demo")
public class AsyncConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.setDefaultTimeout(5000);
        configurer.setTaskExecutor(mcvTaskExecutor());
    }

    @Bean
    public ThreadPoolTaskExecutor mcvTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadGroupName("mvc-executor");
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(30);
        return threadPoolTaskExecutor;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
