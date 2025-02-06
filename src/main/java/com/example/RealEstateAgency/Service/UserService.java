package com.example.RealEstateAgency.Service;

import com.example.RealEstateAgency.Entity.UserRegistration;
import com.example.RealEstateAgency.Repository.UserRegistrationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    //CREATE
    public UserRegistration createUser(UserRegistration userRegistration){
        String username = userRegistration.getUsername();
        if(userRegistrationRepository.findByUsername(username) != null){
             throw new RuntimeException("Username already exist");

        }
        return userRegistrationRepository.save(userRegistration);
    }

    //READ ALL USERS
    public List<UserRegistration> getAllUsers(){
        return (List<UserRegistration>) userRegistrationRepository.findAll();
    }

    //READ USER
    public UserRegistration getUser(String username){
        return userRegistrationRepository.findByUsername(username);
    }

    //UPDATE
    public UserRegistration updateUser( UserRegistration userRegistration){
        UserRegistration USR = userRegistrationRepository.findById(userRegistration.getUserId()).get();

    if(userRegistration.getFirstName() != null && !USR.getFirstName().equals(userRegistration.getFirstName())){
        USR.setFirstName(userRegistration.getFirstName());
    }

    if(userRegistration.getLastName() != null && !USR.getLastName().equals(userRegistration.getLastName())){
        USR.setLastName(userRegistration.getLastName());
    }

    if(userRegistration.getUsername() != null && !USR.getUsername().equals(userRegistration.getUsername())){
        USR.setUsername(userRegistration.getUsername());
    }

    if(userRegistration.getPassword() != null && !USR.getPassword().equals(userRegistration.getPassword())){
        USR.setPassword(userRegistration.getPassword());
    }

    if(userRegistration.getEmail() != null && !USR.getEmail().equals(userRegistration.getEmail())){
        USR.setEmail(userRegistration.getEmail());
    }

    if(userRegistration.getRole() != null && !USR.getRole().equals(userRegistration.getRole())){
        USR.setRole(userRegistration.getRole());
    }

    if(userRegistration.getRealEstateAgencyIdentificationNumber() != null &&
            !USR.getRealEstateAgencyIdentificationNumber().equals(userRegistration.getRealEstateAgencyIdentificationNumber())){
        USR.setRealEstateAgencyIdentificationNumber(userRegistration.getRealEstateAgencyIdentificationNumber());
        }

    return userRegistrationRepository.save(USR);
    }

    //DELETE
    public void deleteUser(Long userId){
        userRegistrationRepository.deleteById(userId);
    }

}
