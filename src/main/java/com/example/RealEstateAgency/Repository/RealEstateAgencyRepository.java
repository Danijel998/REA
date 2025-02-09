package com.example.RealEstateAgency.Repository;

import com.example.RealEstateAgency.Entity.RealEstateAgency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RealEstateAgencyRepository extends JpaRepository<RealEstateAgency, Long> {
    Optional<RealEstateAgency> findByAgencyIdentificationNumber(Long agencyIdentificationNumber);

}
