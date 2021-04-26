package com.doldole.sideproject4timeAttendanceManagement.form;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
    private String name;
    private String rank;
    private Long deptId;
}
