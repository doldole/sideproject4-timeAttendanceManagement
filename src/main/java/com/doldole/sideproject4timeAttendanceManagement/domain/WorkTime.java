package com.doldole.sideproject4timeAttendanceManagement.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WorkTime extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "WORK_TIME_ID")
    private Long id;

    private String workDate;
    private String beginTime;
    private String endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public WorkTime(String workDate, String beginTime, String endTime, Member member) {
        this.workDate = workDate;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.member = member;
    }
}
