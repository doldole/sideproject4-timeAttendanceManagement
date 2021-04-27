package com.doldole.sideproject4timeAttendanceManagement.form;

import com.doldole.sideproject4timeAttendanceManagement.domain.BusinessTripCompanion;
import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusinessTripForm {

    private String beginDe;
    private String beginTime;
    private String endDe;
    private String endTime;
    private int useDe;
    private int useTime;
    private int useMnt;
    private String dstnt;
    private String bsnsPrps;
    private String transportation;
    private Member member;
    private List<Member> companions = new ArrayList<>();

    public BusinessTripForm(String beginDe, String beginTime, String endDe, String endTime, int useDe, int useTime, int useMnt, String dstnt, String bsnsPrps, String transportation, Member member, List<Member> companions) {
        this.beginDe = beginDe;
        this.beginTime = beginTime;
        this.endDe = endDe;
        this.endTime = endTime;
        this.useDe = useDe;
        this.useTime = useTime;
        this.useMnt = useMnt;
        this.dstnt = dstnt;
        this.bsnsPrps = bsnsPrps;
        this.transportation = transportation;
        this.member = member;
        this.companions = companions;
    }
}
