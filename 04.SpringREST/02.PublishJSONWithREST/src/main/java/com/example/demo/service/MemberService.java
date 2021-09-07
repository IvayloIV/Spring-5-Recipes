package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.Members;

public interface MemberService {

    public Members findAll();

    public Member getByName(String name);
}
