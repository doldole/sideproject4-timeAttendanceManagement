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
    private int reqstTime;
    private int reqstMnt;

    private Long empId;
    private String empName;
}
