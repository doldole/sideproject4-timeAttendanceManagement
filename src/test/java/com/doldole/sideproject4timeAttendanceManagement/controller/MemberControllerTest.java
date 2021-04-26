package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.service.DeptService;
import com.doldole.sideproject4timeAttendanceManagement.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberControllerTest {

    @Autowired
    DeptService deptService;

    @Autowired
    MemberService memberService;

    @PersistenceContext
    EntityManager em;

    @Test
    public void 회원등록() throws Exception {
        //given
        Dept dept = new Dept("전산팀", 2, 1L);
        deptService.insertDept(dept);

        em.flush();
        em.clear();

        Dept findDept = em.find(Dept.class, dept.getId());

        Member member = new Member("testA", "사원", findDept);

        //when
        memberService.insertMember(member);

        //then
        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member.getId());

        assertThat(findMember.getName()).isEqualTo("testA");
        assertThat(findMember.getDept().getName()).isEqualTo("전산팀");
        assertThat(findMember.getRank()).isEqualTo("사원");

    }

}