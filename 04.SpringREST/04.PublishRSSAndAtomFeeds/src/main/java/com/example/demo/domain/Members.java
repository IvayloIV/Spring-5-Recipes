package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Members {

    private List<Member> members;

    public Members() {
        members = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
