package com.doldole.sideproject4timeAttendanceManagement.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Period {

    private String beginDe;
    private String beginTime;
    private String endDe;
    private String endTime;
}
