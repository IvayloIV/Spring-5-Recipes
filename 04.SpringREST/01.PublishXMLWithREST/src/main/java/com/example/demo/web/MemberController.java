package com.example.demo.web;

import com.example.demo.domain.Member;
import com.example.demo.domain.Members;
import com.example.demo.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class MemberController {

    private MemberService memberService;
    private Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/member")
    public String getRestMembers(Model model) {
        Members members = this.memberService.findAll();
        model.addAttribute("members", members);
        return "membertemplate";
    }

    @RequestMapping("/member/response")
    @ResponseBody
    public Members getRestMembersResponse() {
        return this.memberService.findAll();
    }

    @RequestMapping("/member/*/{limit}")
    @ResponseBody
    public Members getRestMembersByDate(@PathVariable("limit") Date date) {
        logger.info(date.toString());
        return this.memberService.findAll();
    }

    @RequestMapping("/member/responseEntity/{name}")
    public ResponseEntity<Member> getMembersResponseEntity(@PathVariable String name) {
        Member member = this.memberService.getByName(name);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @InitBinder
    public void initBinding(WebDataBinder webDataBinder) {
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateTimeFormatter, false));
    }
}
