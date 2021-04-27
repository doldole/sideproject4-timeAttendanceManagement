package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.BusinessTrip;
import com.doldole.sideproject4timeAttendanceManagement.domain.BusinessTripCompanion;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import com.doldole.sideproject4timeAttendanceManagement.domain.Period;
import com.doldole.sideproject4timeAttendanceManagement.form.BusinessTripForm;
import com.doldole.sideproject4timeAttendanceManagement.repository.BusinessTripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BusinessTripService {

    private final MemberService memberService;
    private final BusinessTripRepository businessTripRepository;

    @Transactional
    public Long insertBusinessTrip(BusinessTripForm form) {

        ArrayList<BusinessTripCompanion> companions = new ArrayList<>();

        // 동반자 목록 생성
        for (int i = 0; i < form.getCompanions().size(); i++) {
            BusinessTripCompanion companion = BusinessTripCompanion.createCompanion(form.getCompanions().get(i).getId());
            companions.add(companion);
        }

        Member findMember = memberService.findById(form.getMember().getId());

        Period period = new Period(form.getBeginDe(), form.getBeginTime(), form.getEndDe(), form.getEndTime());
        BusinessTrip businessTrip = BusinessTrip.createBusinessTrip(period, form.getUseDe(), form.getUseTime(), form.getUseMnt(), form.getDstnt(), form.getBsnsPrps(), form.getTransportation(), findMember, companions);
        businessTripRepository.save(businessTrip);

        return businessTrip.getId();
    }

    public BusinessTrip findById(Long id) {
        return businessTripRepository.findById(id).get();
    }
}
