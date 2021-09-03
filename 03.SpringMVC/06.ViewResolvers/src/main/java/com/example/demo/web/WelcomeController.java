package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public String welcome(Model model) {
        model.addAttribute("today", new Date());
        return "welcome";
    }

    @GetMapping("/redirect")
    public String welcomeRedirect() {
        return "welcomeRedirect";
    }

    @GetMapping("/redirect2")
    public String welcomeRedirect2() {
        return "redirect:/welcome";
    }
}

