package com.doldole.sideproject4timeAttendanceManagement.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseTimeEntity {

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
