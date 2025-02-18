package com.example.RealEstateAgency.Mapper;

import com.example.RealEstateAgency.DTO.RealEstateDTO;
import com.example.RealEstateAgency.Entity.RealEstate;
import com.example.RealEstateAgency.Repository.RealEstateAgencyRepository;
import com.example.RealEstateAgency.Repository.RealEstateRepository;
import com.example.RealEstateAgency.Repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RealEstateMapper {

    @Autowired
    private RealEstateAgencyRepository realEstateAgencyRepository;
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    public RealEstateDTO mapRealEstateToRealEstateDTO(RealEstate realEstate){
        RealEstateDTO realEstateDTO = new RealEstateDTO();

        realEstateDTO.setRealEstateNameDTO(realEstate.getRealEstateName());
        realEstateDTO.setRealEstateTypeDTO(realEstate.getRealEstateType());
        realEstateDTO.setRealEstateYearDTO(realEstate.getRealEstateYear());
        realEstateDTO.setRealEstateStatusDTO(realEstate.getRealEstateStatus());
        realEstateDTO.setRealEstateDescriptionDTO(realEstate.getRealEstateDescription());
        realEstateDTO.setRealEstatePictureDTO(realEstate.getRealEstatePicture());
        realEstateDTO.setUserIdDTO(realEstate.getUserId().getUserId());
        realEstateDTO.setAgencyIdDTO(realEstate.getAgencyID().getAgencyID());

        return realEstateDTO;
    }


    public RealEstate mapRealEstateDTOToRealEstate(RealEstateDTO realEstateDTO){
        RealEstate realEstate = new RealEstate();

        realEstate.setRealEstateName(realEstateDTO.getRealEstateNameDTO());
        realEstate.setRealEstateType(realEstateDTO.getRealEstateTypeDTO());
        realEstate.setRealEstateYear(realEstateDTO.getRealEstateYearDTO());
        realEstate.setRealEstateStatus(realEstateDTO.getRealEstateStatusDTO());
        realEstate.setRealEstateDescription(realEstateDTO.getRealEstateDescriptionDTO());
        realEstate.setRealEstatePicture(realEstateDTO.getRealEstatePictureDTO());
        realEstate.setUserId(userRegistrationRepository.findById(realEstateDTO.getUserIdDTO()).get());
        realEstate.setAgencyID(realEstateAgencyRepository.findById(realEstateDTO.getAgencyIdDTO()).get());

        return realEstate;
    }

}
