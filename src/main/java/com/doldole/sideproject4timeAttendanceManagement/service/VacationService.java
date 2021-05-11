package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.*;
import com.doldole.sideproject4timeAttendanceManagement.form.VacationForm;
import com.doldole.sideproject4timeAttendanceManagement.repository.VacationRepository;
import com.doldole.sideproject4timeAttendanceManagement.repository.WorkTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VacationService {

    private final MemberService memberService;
    private final VacationRepository vacationRepository;
    private final WorkTimeRepository workTimeRepository;

    @Transactional
    public void insertVacation(VacationForm form) {

        Member findMember = memberService.findById(form.getEmpId());

        int reqstDay = calcReqstTime(findMember.getId(), form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime(), "D");
        int reqstTime = calcReqstTime(findMember.getId(), form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime(), "T");
        int reqstMnt = calcReqstTime(findMember.getId(), form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime(), "M");

        Period period = new Period(form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime());
        Vacation vacation = new Vacation(AttendStatus.NORMAL, form.getVacationType(), period, reqstDay, reqstTime, reqstMnt, findMember);
        vacationRepository.save(vacation);
    }

    public int calcReqstTime(Long empId, String beginDe, String beginTime, String endDe, String endTime, String type) {
        Long calDay = 0L;
        Long calTime = 0L;
        Long calMnt = 0L;

        WorkTime resultWorkTime = workTimeRepository.findByMemberIdAndWorkDate(empId, beginDe);

        String workStdDe = resultWorkTime.getWorkDate();
        String workBeginTime = resultWorkTime.getBeginTime();
        String workEndTime = resultWorkTime.getEndTime();

        String beginDttm = Long.parseLong(workStdDe + workBeginTime) > Long.parseLong(beginDe + beginTime) ? (workStdDe + workBeginTime) : (beginDe + beginTime);
        String endDttm = Long.parseLong(workStdDe + workEndTime) > Long.parseLong(endDe + endTime) ? endDe + endTime : workStdDe + workBeginTime;

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        try {
            Date beginDate = format.parse(beginDttm);
            Date endDate = format.parse(endDttm);

            Long calDate = endDate.getTime() - beginDate.getTime();

            calDay = calDate / (8 * 60 * 60 * 1000);
            calTime = (calDate / (1000 * 60 * 60)) % 8;
            calMnt = (calDate / (1000 * 60)) % 60;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return type.equals("D") ? calDay.intValue() : type.equals("T") ? calTime.intValue() : calMnt.intValue();
    }
}
