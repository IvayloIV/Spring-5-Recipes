package com.example.demo.web.controller;

import com.example.demo.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person*")
public class PersonController {

    @GetMapping
    public String getPerson(Model model) {
        model.addAttribute("player", new Person("Gosho", 22));
        return "playerSummary";
    }
}
