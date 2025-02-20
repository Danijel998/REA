package com.example.RealEstateAgency.Repository;

import com.example.RealEstateAgency.Entity.Role;
import com.example.RealEstateAgency.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUserId(Long userId);
}