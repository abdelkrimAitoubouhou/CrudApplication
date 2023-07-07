package com.example.crud.controller;

import com.example.crud.entities.Student;
import com.example.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {
    @Autowired
     StudentService studentService;


    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }


    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
         studentService.addStudent(student);
    }


    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }


    @GetMapping("deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }



}
