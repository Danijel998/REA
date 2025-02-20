package com.example.RealEstateAgency.Repository;

import com.example.RealEstateAgency.Entity.RealEstateAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RealEstateAgencyRepository extends JpaRepository<RealEstateAgency, Long> {
    Optional<RealEstateAgency> findByAgencyIdentificationNumber(Long agencyIdentificationNumber);

}
