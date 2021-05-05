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
    private Long empId;
    private String empName;
    private String comapnionsId;
    private String comapnionsName;
}
