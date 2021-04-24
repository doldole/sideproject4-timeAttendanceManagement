package com.doldole.sideproject4timeAttendanceManagement.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity extends BaseTimeEntity {
    private Long createUser;
    private Long modifyUser;
}
