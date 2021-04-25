package com.doldole.sideproject4timeAttendanceManagement.repository;

import com.doldole.sideproject4timeAttendanceManagement.domain.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {
}
