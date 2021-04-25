package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.service.DeptService;
import org.assertj.core.api.Assertions;
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
class DeptControllerTest {

    @Autowired
    private DeptService deptService;

    @PersistenceContext
    EntityManager em;

    @Test
    public void 부서등록() throws Exception {
        //given
        Dept dept = new Dept("전산팀", 2, 1L);

        //when
        deptService.insertDept(dept);

        //em.flush();
        //em.clear();

        List<Dept> result = em.createQuery("select d from Dept d", Dept.class)
                .getResultList();

        //then
        assertThat(result.get(0).getName()).isEqualTo("경영지원팀");
        assertThat(result.get(0).getDeptLvl()).isEqualTo(2);
        assertThat(result.size()).isEqualTo(3);
    }
}