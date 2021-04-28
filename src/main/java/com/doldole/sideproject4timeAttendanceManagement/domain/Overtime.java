package com.doldole.sideproject4timeAttendanceManagement.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Overtime extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "OVERTIME_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private AttendStatus overtimeStatus;

    private Period period;

    private int reqstTime;
    private int reqstMnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public Overtime(AttendStatus overtimeStatus, Period period, int reqstTime, int reqstMnt, Member member) {
        this.overtimeStatus = overtimeStatus;
        this.period = period;
        this.reqstTime = reqstTime;
        this.reqstMnt = reqstMnt;
        this.member = member;
    }
}
