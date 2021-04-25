package com.doldole.sideproject4timeAttendanceManagement.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DeptForm {

    @NotEmpty(message = "부서명은 필수항목입니다.")
    private String name;

    @NotNull(message = "레벨은 필수항목입니다.")
    private int deptLvl;

    @NotNull(message = "상위부서코드는 필수항목입니다.")
    private Long parId;
}
