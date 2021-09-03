package com.example.demo.interceptor;

import com.example.demo.web.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalTime;

public class TimeInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalTime date = LocalTime.now();
        request.setAttribute("time", date);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LocalTime date = (LocalTime) request.getAttribute("time");
        Duration finalTime = Duration.between(date, LocalTime.now());
        modelAndView.addObject("finalTime", finalTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("--- Request complete " + response.getStatus());
    }
}
