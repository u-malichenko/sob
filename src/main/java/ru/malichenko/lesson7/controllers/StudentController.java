package ru.malichenko.lesson7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.malichenko.lesson7.dto.StudentDto;
import ru.malichenko.lesson7.entityes.Student;
import ru.malichenko.lesson7.exceptions.ResourceNotFoundException;
import ru.malichenko.lesson7.services.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public String getAll(Model model) {
        List<Student> content = studentService.findAll();
        List<StudentDto> out = content.stream().map(StudentDto::new).collect(Collectors.toList());
        model.addAttribute("student", out);
        return "students";
    }

    @GetMapping(value = "/{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find Student with id: " + id )));
        return "edit";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student s) {
        studentService.saveOrUpdate(s);
        return "redirect:/api/v1/student";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/api/v1/student";
    }
}
