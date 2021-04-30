package com.doldole.sideproject4timeAttendanceManagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String rank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID")
    @JsonIgnore
    private Dept dept;

    public Member(String name, String rank, Dept dept) {
        this.name = name;
        this.rank = rank;
        this.dept = dept;
    }
}
