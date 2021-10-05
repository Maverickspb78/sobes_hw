package com.andreev.demo.controllers;

import com.andreev.demo.dto.StudentDto;
import com.andreev.demo.mapper.StudentMapper;
import com.andreev.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;


    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String studentsList(Model model) {
        model.addAttribute("students", service.getAll());
        return "studentsList";
    }

    @GetMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new StudentDto());
        return "student";
    }

    @GetMapping("/edit/{name}")
    public String editStudent(@PathVariable("name") String name, Model model) {
        model.addAttribute("student",
                StudentMapper.fromStudent(service.findByName(name)));
        return "editStudent";
    }

    @PostMapping("/new")
    public String saveStudent(StudentDto dto, Model model) {
        if (service.save(dto)) {
            return "redirect:/students";
        } else {
            model.addAttribute("student", dto);
            return "student";
        }
    }

    @PostMapping("/update")
    public String updateStudent(StudentDto dto, Model model) {
        service.updateStudent(dto);
        return "redirect:/students";
    }

}