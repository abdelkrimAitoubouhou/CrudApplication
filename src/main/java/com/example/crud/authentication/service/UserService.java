package com.example.crud.authentication.service;

import com.example.crud.authentication.entities.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

public void addNewUser(String username, String password, String confirmPassword, String email);
public void addNewRole(String roleName);
public AppUser findUserByUsername(String username);
public void addRoleToUser(String username, String roleName);
public void deleteUser(String username);
public void deleteRole(String roleName);
public List<AppUser> getUsers();

}
