package com.doldole.sideproject4timeAttendanceManagement.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BusinessTrip extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "BUSINESS_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private AttendStatus businessStatus;

    @Embedded
    private Period period;

    private int useDe;
    private int useTime;
    private int useMnt;
    private String dstnt;
    private String bsnsPrps;
    private String transportation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

}
