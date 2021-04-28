package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.form.OvertimeForm;
import com.doldole.sideproject4timeAttendanceManagement.service.OvertimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class OvertimeController {

    private final OvertimeService overtimeService;

    @GetMapping("/overtime/new")
    public String createOvertimeForm(Model model) {
        model.addAttribute("overtimeForm", new OvertimeForm());
        return "/overtime/overtimeForm";
    }

    @PostMapping("/overtime/new")
    public String createOvertime(@Valid OvertimeForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/overtime/overtimeForm";
        }

        overtimeService.insertOvertime(form);

        return "redirect:/";
    }
}
