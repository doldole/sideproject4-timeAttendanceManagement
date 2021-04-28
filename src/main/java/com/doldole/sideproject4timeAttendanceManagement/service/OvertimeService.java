package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.AttendStatus;
import com.doldole.sideproject4timeAttendanceManagement.domain.Overtime;
import com.doldole.sideproject4timeAttendanceManagement.domain.Period;
import com.doldole.sideproject4timeAttendanceManagement.form.OvertimeForm;
import com.doldole.sideproject4timeAttendanceManagement.repository.OvertimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OvertimeService {

    private final OvertimeRepository overtimeRepository;

    @Transactional
    public Long insertOvertime(OvertimeForm form) {
        Period period = new Period(form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime());
        Overtime overtime = new Overtime(AttendStatus.NORMAL, period, form.getReqstTime(), form.getReqstMnt(), form.getMember());

        overtimeRepository.save(overtime);
        return overtime.getId();
    }
}
