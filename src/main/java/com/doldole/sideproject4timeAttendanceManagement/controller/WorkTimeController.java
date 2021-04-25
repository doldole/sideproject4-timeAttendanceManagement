package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.domain.WorkTime;
import com.doldole.sideproject4timeAttendanceManagement.form.WorkTimeForm;
import com.doldole.sideproject4timeAttendanceManagement.service.WorkTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class WorkTimeController {

    private final WorkTimeService workTimeService;

    @GetMapping("/workTime/new")
    public String workTimeForm(Model model) {
        model.addAttribute("workTimeForm", new WorkTimeForm());
        return "/workTime/workTimeForm";
    }

    @PostMapping("/workTime/new")
    public String createWorkTime(@Valid WorkTimeForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/workTime/workTimeForm";
        }

        //WorkTime workTime = new WorkTime(form.getWorkDate(), form.getBeginTime(), form.getEndTime());
        //workTimeService.insertWorkTime(workTime);

        return "redirect:/";
    }
}
