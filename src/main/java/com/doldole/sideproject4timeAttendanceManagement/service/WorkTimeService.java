package com.doldole.sideproject4timeAttendanceManagement.service;

import com.doldole.sideproject4timeAttendanceManagement.domain.WorkTime;
import com.doldole.sideproject4timeAttendanceManagement.repository.WorkTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkTimeService {

    private final WorkTimeRepository workTimeRepository;

    /**
     * 근무시간 등록
     * */
    @Transactional
    public void insertWorkTime(WorkTime workTime) {
        workTimeRepository.save(workTime);
    }
}
