package com.example.RealEstateAgency.Repository;

import com.example.RealEstateAgency.Entity.UserEntity;
import com.example.RealEstateAgency.Entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {
    UserRegistration findByUsername(String username);
}
