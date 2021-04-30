package com.doldole.sideproject4timeAttendanceManagement;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.initdb();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void initdb() {
            Dept dept = new Dept("경영지원팀", 2, 1L);
            Dept dept2 = new Dept("인사총무팀", 2, 1L);
            em.persist(dept);
            em.persist(dept2);

            Member member1 = new Member("testA", "사원", dept);
            Member member2 = new Member("testB", "과장", dept2);
            Member member3 = new Member("testC", "대리", dept);
            Member member4 = new Member("testD", "차장", dept2);
            Member member5 = new Member("testE", "부장", dept);

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
            em.persist(member5);
        }

    }
}
