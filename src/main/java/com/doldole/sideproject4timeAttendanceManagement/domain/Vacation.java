package com.doldole.sideproject4timeAttendanceManagement.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vacation extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "VACATION_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private AttendStatus vacationStatus;

    private String vacationType;

    @Enumerated
    private Period period;

    private int useDe;
    private int useTime;
    private int useMnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public Vacation(AttendStatus vacationStatus, String vacationType, Period period, int useDe, int useTime, int useMnt, Member member) {
        this.vacationStatus = vacationStatus;
        this.vacationType = vacationType;
        this.period = period;
        this.useDe = useDe;
        this.useTime = useTime;
        this.useMnt = useMnt;
        this.member = member;
    }
}
