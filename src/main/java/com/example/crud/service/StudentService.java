package com.example.crud.service;

import com.example.crud.authentication.entities.AppRole;
import com.example.crud.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> getAll();
    public Student addStudent(Student student);
    public void addRoleToStudent(String studentName, String roleName);
    public Student getStudentByUserName(String userName);
    public void addNewStudent(Student student);
    public void deleteStudent(Long id);

}
