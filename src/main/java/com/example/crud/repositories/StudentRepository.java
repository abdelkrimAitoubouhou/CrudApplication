package com.example.crud.repositories;

import com.example.crud.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
Student findStudentByNom(String username);
}
