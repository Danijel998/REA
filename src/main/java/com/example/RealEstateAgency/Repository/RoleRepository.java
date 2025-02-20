package com.example.RealEstateAgency.Repository;

import com.example.RealEstateAgency.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByRoleId(Long roleId);
}