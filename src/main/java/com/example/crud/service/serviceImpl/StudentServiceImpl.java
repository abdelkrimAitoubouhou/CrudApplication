package com.example.crud.service.serviceImpl;

import com.example.crud.authentication.entities.AppRole;
import com.example.crud.authentication.repository.AppRoleRepository;
import com.example.crud.entities.Student;
import com.example.crud.repositories.StudentRepository;
import com.example.crud.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;
    AppRoleRepository roleRepository;
    public StudentServiceImpl(StudentRepository studentRepository, AppRoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }




    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {

       return studentRepository.save(student);
    }


    @Override
    public void addRoleToStudent(String studentName, String roleName) {

        Student student = studentRepository.findStudentByNom(studentName);
        AppRole appRole = roleRepository.findByRoleName(roleName);
        student.getAppRoles().add(appRole);
        studentRepository.save(student);
    }


    @Override
    public Student getStudentByUserName(String userName) {
        return studentRepository.findStudentByNom(userName);
    }

    @Override
    public void addNewStudent(Student student) {

     /*   Student student1 = studentRepository.findStudentByNom(student.getNom());
        if (student1 != null) throw new RuntimeException("Student already exist");*/
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
