package com.example.crud.authentication.controller;

import com.example.crud.authentication.entities.AppUser;
import com.example.crud.authentication.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")

public class AuthController {

    private UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/getUsers")
    public List<AppUser> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/addNewUser")
    public void addNewUser(@RequestParam String username,@RequestParam String password,
                           @RequestParam String confirmPassword,@RequestParam String email){
        userService.addNewUser(username, password, confirmPassword, email);
    }


    @GetMapping("/admin/addNewRole")
    public void addNewRole(@RequestParam String roleName){
        userService.addNewRole(roleName);
    }

    @GetMapping("/admin/addRoleToUser")
    public void addRoleToUser(@RequestParam String username,@RequestParam String roleName){
        userService.addRoleToUser(username, roleName);
    }


    @GetMapping("/admin/deleteUser")
    public void deleteUser(@RequestParam String username){
        userService.deleteUser(username);
    }


    @GetMapping("/admin/deleteRole")
    public void deleteRole(@RequestParam String roleName){
        userService.deleteRole(roleName);
    }
}
