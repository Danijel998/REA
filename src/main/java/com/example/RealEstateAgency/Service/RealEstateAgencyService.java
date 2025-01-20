package com.example.RealEstateAgency.Service;

import com.example.RealEstateAgency.Entity.RealEstateAgency;
import com.example.RealEstateAgency.Repository.RealEstateAgencyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RealEstateAgencyService {

    @Autowired
    private RealEstateAgencyRepository realEstateAgencyRepository;

    //CREATE operation
    public RealEstateAgency saveRealEstateAgency(RealEstateAgency realEstateAgency){
        return realEstateAgencyRepository.save(realEstateAgency);
    }

    //READ operation
    public List<RealEstateAgency> getRealEstateAgency(){
        return (List<RealEstateAgency>) realEstateAgencyRepository.findAll();
    }

    //UPDATE operation
    public RealEstateAgency updateRealEstateAgency(RealEstateAgency realEstateAgency){
        RealEstateAgency REA = realEstateAgencyRepository.findById(realEstateAgency.getAgencyID()).get();

        if((realEstateAgency.getAgencyIdentificationNumber() != null) &&
                (!REA.getAgencyIdentificationNumber().equals(realEstateAgency.getAgencyIdentificationNumber()))){
            REA.setAgencyIdentificationNumber(realEstateAgency.getAgencyIdentificationNumber());
        }

        if((realEstateAgency.getAgencyName() != null) &&
                (!REA.getAgencyName().equals(realEstateAgency.getAgencyName()))){
            REA.setAgencyName(realEstateAgency.getAgencyName());
        }

        if((realEstateAgency.getAgencyPostcode() != null) &&
                (!REA.getAgencyPostcode().equals(realEstateAgency.getAgencyPostcode()))){
            REA.setAgencyPostcode(realEstateAgency.getAgencyPostcode());
       }

        if((realEstateAgency.getAgencyStreet() != null) &&
                (!REA.getAgencyStreet().equals(realEstateAgency.getAgencyStreet()))){
            REA.setAgencyStreet(realEstateAgency.getAgencyStreet());
        }

       if((realEstateAgency.getAgencyCity() != null) &&
               (!REA.getAgencyCity().equals(realEstateAgency.getAgencyCity()))){
           REA.setAgencyCity(realEstateAgency.getAgencyCity());
       }

        return realEstateAgencyRepository.save(REA);
    }

    //DELETE operation
    public void deleteUser(Long agencyID){
        realEstateAgencyRepository.deleteById(agencyID);
    }
}
