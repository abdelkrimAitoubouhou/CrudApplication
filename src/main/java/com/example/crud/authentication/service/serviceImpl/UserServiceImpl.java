package com.example.crud.authentication.service.serviceImpl;

import com.example.crud.authentication.entities.AppRole;
import com.example.crud.authentication.entities.AppUser;
import com.example.crud.authentication.repository.AppRoleRepository;
import com.example.crud.authentication.repository.AppUserRepository;
import com.example.crud.authentication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {
    private AppUserRepository userRepository;
    private AppRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(AppUserRepository userRepository, AppRoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

     @Override
    public void addNewUser(String username, String password, String confirmPassword, String email) {
        AppUser user = userRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exist");
        if(password!=confirmPassword) throw new RuntimeException("Passwords not matched");

        user = AppUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .confirmPassword(passwordEncoder.encode(confirmPassword))
                .email(email)
                .build();
        userRepository.save(user);

    }

    @Override
    public void addNewRole(String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName);
        if(role!=null) throw new RuntimeException("Role already exist");
        role = AppRole.builder()
                .roleName(roleName)
                .build();
        roleRepository.save(role);

    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = userRepository.findByUsername(username);
        AppRole role = roleRepository.findByRoleName(roleName);
        if(role==null) {
        role = AppRole.builder()
                .roleName(roleName)
                .build();
        roleRepository.save(role);
        }

        user.getAppRoles().add(role);
        userRepository.save(user);

    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public void deleteRole(String roleName) {
       AppRole deletedRole =  roleRepository.findByRoleName(roleName);
       roleRepository.delete(deletedRole);

    }

    @Override
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }
}
