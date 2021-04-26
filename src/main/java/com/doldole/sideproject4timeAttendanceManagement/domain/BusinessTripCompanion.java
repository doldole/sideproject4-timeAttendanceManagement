package com.doldole.sideproject4timeAttendanceManagement.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class BusinessTripCompanion extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "COMPANION_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_ID")
    private BusinessTrip businessTrip;

    private Long memberId;
}
