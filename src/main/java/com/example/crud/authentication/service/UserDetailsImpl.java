package com.example.crud.authentication.service;

import com.example.crud.authentication.entities.AppRole;
import com.example.crud.authentication.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsImpl implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userService.findUserByUsername(username);
        if (user==null) throw new RuntimeException("User not found");

        UserDetails userDetails = User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getAppRoles().stream().map(AppRole::getRoleName).toArray(String[]::new))
                .build();

        return userDetails;
    }
}
