package com.doldole.sideproject4timeAttendanceManagement.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Period {

    private String beginDe;
    private String beginTime;
    private String endDe;
    private String endTime;

    public Period(String beginDe, String beginTime, String endDe, String endTime) {
        this.beginDe = beginDe;
        this.beginTime = beginTime;
        this.endDe = endDe;
        this.endTime = endTime;
    }
}
