package com.example.RealEstateAgency.DTO;

import com.example.RealEstateAgency.Entity.RealEstateAgency;
import com.example.RealEstateAgency.Entity.UserRegistration;
import com.example.RealEstateAgency.Enums.RealEstateStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class RealEstateDTO {

    private String realEstateNameDTO;
    private String realEstateTypeDTO;
    private LocalDate realEstateYearDTO;
    private RealEstateStatus realEstateStatusDTO;
    private String realEstateDescriptionDTO;
    private String realEstatePictureDTO;
    private UserRegistration realEstateAgentDTO;
    private RealEstateAgency realEstateAgencyDTO;

}
