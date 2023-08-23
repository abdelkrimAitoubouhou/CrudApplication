package com.example.crud;

import com.example.crud.authentication.service.UserService;
import com.example.crud.entities.Student;
import com.example.crud.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner authentication(UserService userService) {
        return args -> {

            userService.addNewUser("admin", "1234", "1234", "admin@gmail.com");
            userService.addNewUser("user", "1234", "1234", "user@gmail.com");

            userService.addNewRole("USER");
            userService.addNewRole("ADMIN");

            userService.addRoleToUser("admin", "ADMIN");
            userService.addRoleToUser("admin", "USER");
            userService.addRoleToUser("user", "USER");

        };
    }


    @Bean
    CommandLineRunner runner (StudentService studentService){
        return args -> {
            studentService.addNewStudent(new Student(null, "karim", "aitoubouhou",
                    "karim@gmail.com",new HashSet<>()));
            studentService.addNewStudent(new Student(null, "mohammed", "anouar",
                    "mohammed@gmail.com", new HashSet<>()));
            studentService.addNewStudent(new Student(null, "ahmed", "majed",
                    "mohammed@gmail.com",new HashSet<>()));
            studentService.addNewStudent(new Student(null, "jamal", "jamal",
                    "jamal@gmail.com",new HashSet<>()));

            studentService.addRoleToStudent("karim", "USER");
            studentService.addRoleToStudent("mohammed", "USER");
            studentService.addRoleToStudent("ahmed", "USER");
        };
    }
}
