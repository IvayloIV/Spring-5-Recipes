package com.example.demo.web;

import com.example.demo.domain.Member;
import com.example.demo.domain.Members;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    private final String remoteUri = "http://localhost:8080/demo";
    private Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    private RestTemplate restTemplate;

    @Autowired
    public WelcomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String welcome(Model model) {
//        String members = restTemplate.getForObject(remoteUri + "/member.json", String.class);
//        logger.info(members);

//        Map<String, String> params = new HashMap<>();
//        params.put("name", "Gosho");
//        String member = restTemplate.getForObject(remoteUri + "/member/responseEntity/{name}", String.class, params);
//        logger.info(member);

        Member member = restTemplate.getForObject(remoteUri + "/member/responseEntity/{name}", Member.class, "Tosho");
        logger.info(member.toString());
        model.addAttribute("today", new Date());
        return "welcome";
    }
}

