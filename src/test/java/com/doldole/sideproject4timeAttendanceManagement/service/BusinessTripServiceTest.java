package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.BusinessTrip;
import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.domain.Period;
import com.doldole.sideproject4timeAttendanceManagement.form.BusinessTripForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class BusinessTripServiceTest {

    @Autowired
    BusinessTripService businessTripService;

    @PersistenceContext
    EntityManager em;

    @Test
    public void 출장신청() throws Exception {
        //given
        Dept dept = new Dept("경영지원팀", 1, 1L);
        Dept dept2 = new Dept("전산팀", 1, 1L);
        em.persist(dept);
        em.persist(dept2);

        Member member1 = new Member("testA", "사원", dept);
        Member member2 = new Member("testB", "사원", dept);
        Member member3 = new Member("testC", "사원", dept);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);

        ArrayList<Member> companions = new ArrayList<>();
        companions.add(member2);
        companions.add(member3);

        BusinessTripForm form = new BusinessTripForm("20210427", "0900", "20210427", "1400", 1, 0, 0, "출장지", "목적지", "교통편", member1, companions);

        //when
        Long findId = businessTripService.insertBusinessTrip(form);

        //then
        em.flush();
        em.clear();

        BusinessTrip result = businessTripService.findById(findId);

        assertThat(result.getCompanions().size()).isEqualTo(2);
        assertThat(result.getCompanions().get(0).getMemberId()).isEqualTo(6);
    }
}