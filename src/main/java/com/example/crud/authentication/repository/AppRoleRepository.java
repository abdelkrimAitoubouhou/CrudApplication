package com.example.crud.authentication.repository;

import com.example.crud.authentication.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
    AppRole deleteByRoleName(String roleName);
}
