package com.example.crud.service;

import com.example.crud.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> getAll();
    public Student getStudentById(Long id);
    public void addStudent(Student student);
    public void deleteStudent(Long id);
    public Student updateStudent(Student student);

}
