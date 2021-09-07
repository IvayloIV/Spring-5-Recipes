package com.example.demo.web;

import com.example.demo.domain.Members;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/member/atom")
    public String getRestMembers(Model model) {
        Members members = this.memberService.findAll();
        model.addAttribute("members", members);
        return "atomMemberTemplate";
    }

    @RequestMapping("/member/rss")
    public String getRssMembers(Model model) {
        Members members = this.memberService.findAll();
        model.addAttribute("members", members);
        return "rssMemberTemplate";
    }
}
