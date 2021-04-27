package com.doldole.sideproject4timeAttendanceManagement.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "businessTrip", cascade = CascadeType.ALL)
    private List<BusinessTripCompanion> companions = new ArrayList<>();

    public BusinessTrip(Period period, AttendStatus businessStatus, int useDe, int useTime, int useMnt, String dstnt, String bsnsPrps, String transportation, Member member) {
        this.period = period;
        this.businessStatus = businessStatus;
        this.useDe = useDe;
        this.useTime = useTime;
        this.useMnt = useMnt;
        this.dstnt = dstnt;
        this.bsnsPrps = bsnsPrps;
        this.transportation = transportation;
        this.member = member;
    }

    //== 연관관계 메서드 ==//
    public void addCompanion(BusinessTripCompanion companion) {
        companions.add(companion);
        companion.addBusinessTrip(this);
    }

    //== 비즈니스 로직 ==//
    public static BusinessTrip createBusinessTrip(Period period, int useDe, int useTime, int useMnt, String dstnt, String bsnsPrps, String transportation, Member member, ArrayList<BusinessTripCompanion> businessTripCompanions) {
        BusinessTrip businessTrip = new BusinessTrip(period, AttendStatus.NORMAL, useDe, useTime, useMnt, dstnt, bsnsPrps, transportation, member);

        for (BusinessTripCompanion companion : businessTripCompanions) {
            businessTrip.addCompanion(companion);
        }

        return businessTrip;
    }
}
