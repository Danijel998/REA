package com.example.RealEstateAgency.Mapper;

import com.example.RealEstateAgency.DTO.RealEstateAgencyDTO;
import com.example.RealEstateAgency.Entity.RealEstateAgency;
import org.springframework.stereotype.Component;

@Component
public class RealEstateAgencyMapper {


    public RealEstateAgencyDTO mapRealEstateAgencyToRealEstateAgencyDTO(RealEstateAgency realEstateAgency){
        RealEstateAgencyDTO realEstateAgencyDTO = new RealEstateAgencyDTO();

        realEstateAgencyDTO.setAgencyIdentificationNumberDTO(realEstateAgency.getAgencyIdentificationNumber());
        realEstateAgencyDTO.setAgencyNameDTO(realEstateAgency.getAgencyName());
        realEstateAgencyDTO.setAgencyPostcodeDTO(realEstateAgency.getAgencyPostcode());
        realEstateAgencyDTO.setAgencyStreetDTO(realEstateAgency.getAgencyStreet());
        realEstateAgencyDTO.setAgencyCityDTO(realEstateAgency.getAgencyCity());
        return realEstateAgencyDTO;
    }

    public RealEstateAgency mapRealEstateAgencyDTOToRealEstateAgency(RealEstateAgencyDTO realEstateAgencyDTO){
        RealEstateAgency realEstateAgency = new RealEstateAgency();

        realEstateAgency.setAgencyIdentificationNumber(realEstateAgencyDTO.getAgencyIdentificationNumberDTO());
        realEstateAgency.setAgencyName(realEstateAgencyDTO.getAgencyNameDTO());
        realEstateAgency.setAgencyPostcode(realEstateAgencyDTO.getAgencyPostcodeDTO());
        realEstateAgency.setAgencyStreet(realEstateAgencyDTO.getAgencyStreetDTO());
        realEstateAgency.setAgencyCity(realEstateAgencyDTO.getAgencyCityDTO());
        return realEstateAgency;
    }


}
