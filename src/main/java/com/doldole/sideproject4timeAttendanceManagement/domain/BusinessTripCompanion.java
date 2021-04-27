package com.doldole.sideproject4timeAttendanceManagement.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public BusinessTripCompanion(Long memberId) {
        this.memberId = memberId;
    }

    //== 생성 메서드 ==//
    public static BusinessTripCompanion createCompanion(Long memberId) {
        return new BusinessTripCompanion(memberId);
    }

    public void addBusinessTrip(BusinessTrip businessTrip) {
        this.businessTrip = businessTrip;
    }
}
