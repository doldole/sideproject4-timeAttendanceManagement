package com.doldole.sideproject4timeAttendanceManagement.controller;

import com.doldole.sideproject4timeAttendanceManagement.domain.Dept;
import com.doldole.sideproject4timeAttendanceManagement.form.DeptForm;
import com.doldole.sideproject4timeAttendanceManagement.repository.DeptRepository;
import com.doldole.sideproject4timeAttendanceManagement.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;

    @GetMapping("/dept/new")
    public String deptForm(Model model) {
        model.addAttribute("deptForm", new DeptForm());
        return "/dept/deptForm";
    }

    @PostMapping("/dept/new")
    public String createDept(@Valid DeptForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/dept/deptForm";
        }

        Dept dept = new Dept(form.getName(), form.getDeptLvl(), form.getParId());
        Long deptId = deptService.insertDept(dept);

        return "redirect:/";
    }
}
