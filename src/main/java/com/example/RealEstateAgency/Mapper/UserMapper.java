package com.example.RealEstateAgency.Mapper;

import com.example.RealEstateAgency.DTO.UserDTO;
import com.example.RealEstateAgency.Entity.UserRegistration;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO mapUsertoUserDto(UserRegistration userRegistration){
        UserDTO userDto = new UserDTO();

        userDto.setFirstName(userRegistration.getFirstName());
        userDto.setLastName(userRegistration.getLastName());
        userDto.setUsername(userRegistration.getUsername());
        userDto.setEmail(userRegistration.getEmail());
        userDto.setPassword(userRegistration.getPassword());
        userDto.setRealEstateAgencyIdentificationNumber(userRegistration.getRealEstateAgencyIdentificationNumber());
        return userDto;
    }

    public UserRegistration mapUserDTOtoUser(UserDTO userDTO){
        UserRegistration userRegistration = new UserRegistration();

        userRegistration.setFirstName(userDTO.getFirstName());
        userRegistration.setLastName(userDTO.getLastName());
        userRegistration.setUsername(userDTO.getUsername());
        userRegistration.setEmail(userDTO.getEmail());
        userRegistration.setPassword(userDTO.getPassword());
        userRegistration.setRealEstateAgencyIdentificationNumber(userDTO.getRealEstateAgencyIdentificationNumber());
        return userRegistration;
    }


}
