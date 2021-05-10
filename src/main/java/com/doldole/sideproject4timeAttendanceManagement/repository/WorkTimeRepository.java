package com.doldole.sideproject4timeAttendanceManagement.repository;

import com.doldole.sideproject4timeAttendanceManagement.domain.WorkTime;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {

    WorkTime findByMemberIdAndWorkDate(Long empId, String stdDe);
}
