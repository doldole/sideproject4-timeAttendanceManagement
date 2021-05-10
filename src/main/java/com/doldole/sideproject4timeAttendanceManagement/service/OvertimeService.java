package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.*;
import com.doldole.sideproject4timeAttendanceManagement.form.OvertimeForm;
import com.doldole.sideproject4timeAttendanceManagement.repository.OvertimeRepository;
import com.doldole.sideproject4timeAttendanceManagement.repository.WorkTimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OvertimeService {

    private final OvertimeRepository overtimeRepository;
    private final MemberService memberService;
    private final WorkTimeRepository workTimeRepository;

    static Logger logger = Logger.getLogger("OvertimeService.class");

    @Transactional
    public Long insertOvertime(OvertimeForm form) {
        Period period = new Period(form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime());
        Member member = memberService.findById(form.getEmpId());

        int reqstTime = calcReqstTime(member.getId(), form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime(), "T");
        int reqstMnt = calcReqstTime(member.getId(), form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime(), "M");

        Overtime overtime = new Overtime(AttendStatus.NORMAL, period, reqstTime, reqstMnt, member);

        overtimeRepository.save(overtime);
        return overtime.getId();
    }

    public int calcReqstTime(Long empId, String beginDe, String beginTime, String endDe, String endTime, String type) {
        Long calTime = 0L;
        Long calMnt = 0L;

        WorkTime resultWorkTime = workTimeRepository.findByMemberIdAndWorkDate(empId, beginDe);

        String workStdDe = resultWorkTime.getWorkDate();
        String workBeginTime = resultWorkTime.getBeginTime();
        String workEndTime = resultWorkTime.getEndTime();

        String beginDttm = Long.parseLong(workStdDe + workEndTime) > Long.parseLong(beginDe + beginTime) ? (workStdDe + workEndTime) : (beginDe + beginTime);
        String endDttm = Long.parseLong(workStdDe + workBeginTime) > Long.parseLong(endDe + endTime) ? workStdDe + workBeginTime : endDe + endTime;

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        try {
            Date beginDate = format.parse(beginDttm);
            Date endDate = format.parse(endDttm);

            Long calDate = endDate.getTime() - beginDate.getTime();

            //Long calTime = calDate / (24 * 60 * 60 * 1000);
            calTime = calDate / (1000 * 60 * 60);
            calMnt = (calDate / (1000 * 60)) % 60;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return type.equals("T") ? calTime.intValue() : calMnt.intValue();
    }
}
