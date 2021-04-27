package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.domain.BusinessTripCompanion;
import com.doldole.sideproject4timeAttendanceManagement.form.BusinessTripForm;
import com.doldole.sideproject4timeAttendanceManagement.service.BusinessTripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BusinessTripController {

    private final BusinessTripService businessTripService;

    @GetMapping("/businessTrip/new")
    public String businessTripForm(Model model) {
        model.addAttribute("businessTripForm", new BusinessTripForm());
        return "/businessTrip/businessTripForm";
    }

    @PostMapping("/businessTrip/new")
    public String createBusinessTrip(@Valid BusinessTripForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/businessTrip/businessTripForm";
        }

        businessTripService.insertBusinessTrip(form);
        return "redirect:/";
    }
}
