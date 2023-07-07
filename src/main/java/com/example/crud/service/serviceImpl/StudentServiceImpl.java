package com.example.crud.service.serviceImpl;

import com.example.crud.entities.Student;
import com.example.crud.repositories.StudentRepository;
import com.example.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
     StudentRepository studentRepository;


    @Override
    public List<Student> getAll() {
        //return studentRepository.findAll();
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(stud -> students.add(stud));
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);

    }
}
