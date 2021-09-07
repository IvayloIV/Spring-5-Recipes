package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.Members;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MemberServiceImp implements MemberService {

    private Members members;

    @PostConstruct
    public void init() {
        members = new Members();
        List<Member> membersList = members.getMembers();
        membersList.add(new Member("Ivan", 43));
        membersList.add(new Member("Pesho", 45));
        membersList.add(new Member("Gosho", 23));
        membersList.add(new Member("Tosho", 13));
    }

    @Override
    public Members findAll() {
        return members;
    }
}
