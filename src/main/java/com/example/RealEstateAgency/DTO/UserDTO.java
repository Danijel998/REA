package com.example.RealEstateAgency.DTO;


import lombok.*;

@Setter
@Getter
@Data
public class UserDTO {

    private Long userIdDTO;
    private String firstNameDTO;
    private String lastNameDTO;
    private String usernameDTO;
    private String emailDTO;
    private String passwordDTO;
    private Long realEstateAgencyIdentificationNumberDTO;


}
