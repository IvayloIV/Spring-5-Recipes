package com.example.demo.web;

import com.example.demo.domain.Members;
import com.example.demo.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
public class MemberController {

    private MemberService memberService;
    private Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(path = "/member*", produces = APPLICATION_XML_VALUE)
    public String getXmlRestMembers(Model model) {
        Members members = this.memberService.findAll();
        model.addAttribute("members", members);
        return "membertemplate";
    }

    @RequestMapping(path = "/member*", produces = APPLICATION_JSON_VALUE)
    public String getJsonRestMembers(Model model) {
        Members members = this.memberService.findAll();
        model.addAttribute("members", members);
        return "jsonmembertemplate";
    }

    @RequestMapping("/member/response*")
    @ResponseBody
    public Members getRestMembersResponse() {
        return this.memberService.findAll();
    }
}
