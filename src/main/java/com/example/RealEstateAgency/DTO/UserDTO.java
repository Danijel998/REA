package com.example.RealEstateAgency.DTO;


import lombok.*;

@Setter
@Getter
@Data
public class UserDTO {

    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Long realEstateAgencyIdentificationNumber;


}
