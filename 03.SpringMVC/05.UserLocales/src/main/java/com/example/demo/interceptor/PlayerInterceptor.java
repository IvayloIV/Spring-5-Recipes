package com.example.demo.interceptor;

import com.example.demo.web.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlayerInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Player controller start!");
        return true;
    }
}
