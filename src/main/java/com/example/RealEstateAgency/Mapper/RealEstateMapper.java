package com.example.RealEstateAgency.Mapper;

import com.example.RealEstateAgency.DTO.RealEstateDTO;
import com.example.RealEstateAgency.Entity.RealEstate;
import org.springframework.stereotype.Component;

@Component
public class RealEstateMapper {


    public RealEstateDTO mapRealEstateToRealEstateDTO(RealEstate realEstate){
        RealEstateDTO realEstateDTO = new RealEstateDTO();

        realEstateDTO.setRealEstateName
        realEstateDTO.setRealEstateTypeDTO(realEstate.getRealEstateType());
        realEstateDTO.setRealEstateYearDTO(realEstate.getRealEstateYear());
        realEstateDTO.setRealEstateStatusDTO(realEstate.getRealEstateStatus());
        realEstateDTO.setRealEstateDescriptionDTO(realEstate.getRealEstateDescription());
        realEstateDTO.setRealEstatePictureDTO(realEstate.getRealEstatePicture());
        realEstateDTO.setRealEstateAgentDTO(realEstate.getRealEstateAgent());
        realEstateDTO.setRealEstateAgencyDTO(realEstate.getRealEstateAgency());

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
        realEstate.setRealEstateAgent(realEstateDTO.getRealEstateAgentDTO());
        realEstate.setRealEstateAgency(realEstateDTO.getRealEstateAgencyDTO());

        return realEstate;
    }

}
