package com.hello.servlet.web.frontcontroller.v4.controller;

import com.hello.servlet.domain.Member;
import com.hello.servlet.domain.MemberRepository;
import com.hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model ) {
        System.out.println("MemberListControllerV3.process");
        List<Member> members = memberRepository.findAll();

        model.put("members", members);
        return "members";
    }
}
