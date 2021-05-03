package com.doldole.sideproject4timeAttendanceManagement.form;

import com.doldole.sideproject4timeAttendanceManagement.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class WorkTimeForm {

    @NotEmpty(message = "근무 일자는 필수항목입니다.")
    private String workDate;

    @NotEmpty(message = "근무시작시간은 필수항목입니다.")
    private String beginTime;

    @NotEmpty(message = "근무종료시간은 필수항목입니다.")
    private String endTime;

    private Long empId;
    private String empName;
}
