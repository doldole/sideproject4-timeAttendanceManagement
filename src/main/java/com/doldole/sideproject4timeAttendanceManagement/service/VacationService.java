package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.AttendStatus;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.domain.Period;
import com.doldole.sideproject4timeAttendanceManagement.domain.Vacation;
import com.doldole.sideproject4timeAttendanceManagement.form.VacationForm;
import com.doldole.sideproject4timeAttendanceManagement.repository.VacationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VacationService {

    private final MemberService memberService;
    private final VacationRepository vacationRepository;

    @Transactional
    public void insertVacation(VacationForm form) {

        Member findMember = memberService.findById(form.getEmpId());

        Period period = new Period(form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime());
        Vacation vacation = new Vacation(AttendStatus.NORMAL, form.getVacationType(), period, 0, 0, 0, findMember);
        vacationRepository.save(vacation);
    }
}
