package com.doldole.sideproject4timeAttendanceManagement.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Dept extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "DEPT_ID")
    private Long id;

    @Column(name = "DEPT_NAME")
    private String name;

    private int deptLvl;

    private Long parId;

    public Dept(String name, int deptLvl, Long parId) {
        this.name = name;
        this.deptLvl = deptLvl;
        this.parId = parId;
    }
}
