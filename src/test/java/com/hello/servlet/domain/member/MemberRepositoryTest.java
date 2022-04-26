package com.hello.servlet.domain.member;

import com.hello.servlet.domain.Member;
import com.hello.servlet.domain.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("choi", 30);

        //when
        Member result = memberRepository.save(member);

        //then
        assertThat(result.getUsername()).isEqualTo("choi");
        assertThat(result.getAge()).isEqualTo(30);
        Member foundMember = memberRepository.findById(result.getId());
        assertThat(member).isEqualTo(member);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("mem1", 20);
        Member member2 = new Member("mem2", 21);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> memberList = memberRepository.findAll();

        //then
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1, member2);
    }


}
