package com.doldole.sideproject4timeAttendanceManagement.repository;

import com.doldole.sideproject4timeAttendanceManagement.domain.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OvertimeRepository extends JpaRepository<Overtime, Long> {
}
