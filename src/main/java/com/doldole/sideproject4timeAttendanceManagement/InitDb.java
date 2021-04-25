package com.doldole.sideproject4timeAttendanceManagement;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
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
        }

    }
}
