package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    @RequestMapping("add")
    public String addMember(Model model) {
        model.addAttribute("currDate", new Date());
        return "member";
    }

    @RequestMapping(value = { "delete", "remove" }, method = RequestMethod.GET)
    public String createMember(Model model) {
        model.addAttribute("currDate", "Deleted");
        return "member";
    }

    @RequestMapping(value = "take/{info}")
    public String takeMember(@PathVariable("info") String test,  Model model) {
        model.addAttribute("currDate", test);
        return "member";
    }

    @GetMapping("test")
    public String testMember(Model model) {
        model.addAttribute("currDate", "test message");
        return "member";
    }

    @RequestMapping
    public String giveMember(Model model) {
        model.addAttribute("currDate", "default message!!!");
        return "member";
    }
}
