package com.doldole.sideproject4timeAttendanceManagement.repository;

import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {


}
