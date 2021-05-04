package com.doldole.sideproject4timeAttendanceManagement.repository;

import com.doldole.sideproject4timeAttendanceManagement.domain.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
