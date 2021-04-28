package com.doldole.sideproject4timeAttendanceManagement.form;

import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OvertimeForm {
    private String beginDe;
    private String beginTime;
    private String endDe;
    private String endTime;
    private int ReqstTime;
    private int ReqstMnt;
    private Member member;

    public OvertimeForm(String beginDe, String beginTime, String endDe, String endTime, int reqstTime, int reqstMnt, Member member) {
        this.beginDe = beginDe;
        this.beginTime = beginTime;
        this.endDe = endDe;
        this.endTime = endTime;
        ReqstTime = reqstTime;
        ReqstMnt = reqstMnt;
        this.member = member;
    }
}
