package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.domain.Overtime;
import com.doldole.sideproject4timeAttendanceManagement.form.OvertimeForm;
import com.doldole.sideproject4timeAttendanceManagement.service.OvertimeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class OvertimeControllerTest {

    @Autowired
    OvertimeService overtimeService;

    @PersistenceContext
    EntityManager em;

    @Test
    public void 초과근무_등록() throws Exception {
        //given
        Dept dept = new Dept("경영지원팀", 1, 1L);
        em.persist(dept);

        Member member1 = new Member("testA", "사원", dept);
        em.persist(member1);

        OvertimeForm overtimeForm = new OvertimeForm("20210427", "0900", "20210427", "1400", 5, 0, member1);

        //when
        overtimeService.insertOvertime(overtimeForm);

        em.flush();
        em.clear();

        List<Overtime> result = em.createQuery("select o from Overtime o", Overtime.class)
                .getResultList();

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getReqstTime()).isEqualTo(5);
        assertThat(result.get(0).getMember().getName()).isEqualTo("testA");
    }
}