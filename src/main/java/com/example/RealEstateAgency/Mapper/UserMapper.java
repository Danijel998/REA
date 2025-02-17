package com.example.RealEstateAgency.Mapper;

import com.example.RealEstateAgency.DTO.UserDTO;
import com.example.RealEstateAgency.Entity.UserRegistration;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO mapUsertoUserDto(UserRegistration userRegistration){
        UserDTO userDto = new UserDTO();

        userDto.setFirstNameDTO(userRegistration.getFirstName());
        userDto.setLastNameDTO(userRegistration.getLastName());
        userDto.setUsernameDTO(userRegistration.getUsername());
        userDto.setEmailDTO(userRegistration.getEmail());
        userDto.setPasswordDTO(userRegistration.getPassword());
        userDto.setRealEstateAgencyIdentificationNumberDTO(userRegistration.getRealEstateAgencyIdentificationNumber());
        return userDto;
    }

    public UserRegistration mapUserDTOtoUser(UserDTO userDTO){
        UserRegistration userRegistration = new UserRegistration();

        userRegistration.setFirstName(userDTO.getFirstNameDTO());
        userRegistration.setLastName(userDTO.getLastNameDTO());
        userRegistration.setUsername(userDTO.getUsernameDTO());
        userRegistration.setEmail(userDTO.getEmailDTO());
        userRegistration.setPassword(userDTO.getPasswordDTO());
        userRegistration.setRealEstateAgencyIdentificationNumber(userDTO.getRealEstateAgencyIdentificationNumberDTO());
        return userRegistration;
    }


}
