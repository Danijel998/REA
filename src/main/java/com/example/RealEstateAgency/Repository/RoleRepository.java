package com.example.RealEstateAgency.Repository;

import com.example.RealEstateAgency.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByRoleId(Long roleId);
}