package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.repository.DeptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeptService {

    private final DeptRepository deptRepository;

    /**
     * 부서 등록
     */
    @Transactional
    public Long insertDept(Dept dept) {
        deptRepository.save(dept);
        return dept.getId();
    }
}
