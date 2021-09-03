package com.example.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ExtensionInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String finalName = null;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE;
        String time = timeFormatter.format(LocalDateTime.now());

        if (request.getServletPath().endsWith(".pdf")) {
            finalName = "PdfSummary_" + time + ".pdf";
        } else if (request.getServletPath().endsWith(".xls")) {
            finalName = "XlsSummary_" + time + ".xls";
        }

        if (finalName != null) {
            response.setHeader("Content-Disposition", "attachment; filename=" + finalName);
        }
    }
}
