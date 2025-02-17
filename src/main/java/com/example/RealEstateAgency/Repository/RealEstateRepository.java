package com.example.RealEstateAgency.Repository;

import com.example.RealEstateAgency.Entity.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {
    RealEstate findByRealEstateName(String realEstateName);
}
