package com.example.crud.security;

import com.example.crud.authentication.service.UserDetailsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  private UserDetailsImpl userDetails;

  public SecurityConfiguration(UserDetailsImpl userDetails) {
    this.userDetails = userDetails;
  }


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

    httpSecurity
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/user/**")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/admin/**")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
            );


    httpSecurity .formLogin();
    httpSecurity  .authorizeHttpRequests().anyRequest().permitAll();
    httpSecurity.headers(headers -> headers.frameOptions().disable());
    httpSecurity.csrf(csrf -> csrf
            .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
    //httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");
    httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");
    httpSecurity.userDetailsService(userDetails);



    return httpSecurity.build();
  };



}
