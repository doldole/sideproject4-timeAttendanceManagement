package com.doldole.sideproject4timeAttendanceManagement.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacationForm {
    private String beginDe;
    private String beginTime;
    private String endDe;
    private String endTime;
    private String vacationType;

    private Long empId;
    private String empName;
}
