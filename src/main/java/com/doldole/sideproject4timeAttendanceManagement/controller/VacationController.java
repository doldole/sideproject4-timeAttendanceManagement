package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.form.OvertimeForm;
import com.doldole.sideproject4timeAttendanceManagement.form.VacationForm;
import com.doldole.sideproject4timeAttendanceManagement.repository.VacationRepository;
import com.doldole.sideproject4timeAttendanceManagement.service.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class VacationController {

    private final VacationService vacationService;

    @GetMapping("/vacation/new")
    public String createOvertimeForm(Model model) {
        model.addAttribute("vacationForm", new VacationForm());
        return "/vacation/vacationForm";
    }

    @PostMapping("/vacation/new")
    public String createOvertime(@Valid VacationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/vacation/vacationForm";
        }

        vacationService.insertVacation(form);

        return "redirect:/";
    }
}
