package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.*;
import com.doldole.sideproject4timeAttendanceManagement.form.BusinessTripForm;
import com.doldole.sideproject4timeAttendanceManagement.repository.BusinessTripRepository;
import com.doldole.sideproject4timeAttendanceManagement.repository.WorkTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BusinessTripService {

    private final MemberService memberService;
    private final BusinessTripRepository businessTripRepository;
    private final WorkTimeRepository workTimeRepository;

    @Transactional
    public Long insertBusinessTrip(BusinessTripForm form) {

        ArrayList<BusinessTripCompanion> companions = new ArrayList<>();

        // 동반자 목록 생성
        String[] companionsId = form.getComapnionsId().split(",");

        for (int i = 0; i < companionsId.length; i++) {
            BusinessTripCompanion companion = BusinessTripCompanion.createCompanion(Long.parseLong(companionsId[i]));
            companions.add(companion);
        }

        Member findMember = memberService.findById(form.getEmpId());

        int reqstDay = calcReqstTime(findMember.getId(), form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime(), "D");
        int reqstTime = calcReqstTime(findMember.getId(), form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime(), "T");
        int reqstMnt = calcReqstTime(findMember.getId(), form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime(), "M");

        Period period = new Period(form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime());
        BusinessTrip businessTrip = BusinessTrip.createBusinessTrip(period, reqstDay, reqstTime, reqstMnt, form.getDstnt(), form.getBsnsPrps(), form.getTransportation(), findMember, companions);
        businessTripRepository.save(businessTrip);

        return businessTrip.getId();
    }

    public BusinessTrip findById(Long id) {
        return businessTripRepository.findById(id).get();
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
