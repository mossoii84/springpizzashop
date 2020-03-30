package com.example.springpizzashop.security.repository;


import com.example.springpizzashop.security.model.Role;
import com.example.springpizzashop.security.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByUserRole(Roles role);
}
