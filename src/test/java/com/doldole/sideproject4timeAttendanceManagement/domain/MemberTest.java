package com.doldole.sideproject4timeAttendanceManagement.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void memberTest() {
        Dept dept = new Dept("test");
        em.persist(dept);

        Member member = new Member("member1", "AA", dept);
        em.persist(member);
    }

}