package com.example.RealEstateAgency.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RealEstateAgencyDTO {

    private Long agencyIdentificationNumberDTO;
    private String agencyNameDTO;
    private Integer agencyPostcodeDTO;
    private String agencyStreetDTO;
    private String agencyCityDTO;

}
