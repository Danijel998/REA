package com.example.RealEstateAgency.Repository;

import com.example.RealEstateAgency.Entity.Role;
import com.example.RealEstateAgency.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUserId(Long userId);
}