package com.example.crud.controller;

import com.example.crud.entities.Student;
import com.example.crud.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/stud")


public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/admin/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @PostMapping("/admin/addStudent")
    public Student addStudent(@RequestBody Student student){
        Student addedStudent = studentService.addStudent(student);
        return addedStudent;
    }

    @GetMapping("/admin/deleteStudent")
    public void deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
    }


}
