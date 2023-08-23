package com.example.crud.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthException {

    @GetMapping("/notAuthorized")
    public String notAuthorized(){
        return " You're not Authorized";
    }

}
