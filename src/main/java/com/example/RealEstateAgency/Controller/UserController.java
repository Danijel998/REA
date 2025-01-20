package com.example.RealEstateAgency.Controller;

import com.example.RealEstateAgency.Entity.UserRegistration;
import com.example.RealEstateAgency.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //CREATE
    @PostMapping("/createAgent")
    public ResponseEntity<UserRegistration> createUser(@RequestBody UserRegistration userRegistration){
        userRegistration.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        UserRegistration savedUser = userService.createUser(userRegistration);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //READ
    @GetMapping("/agentList")
    public ResponseEntity<List<UserRegistration>> getUser(){
        List<UserRegistration> getAllUsers = userService.getUser();
        return new ResponseEntity<>(getAllUsers, HttpStatus.FOUND);
    }

    //UPDATE
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserRegistration> updateUser(@PathVariable("id")Long userId,
                                           @RequestBody UserRegistration userRegistration){
        userRegistration.setUserId(userId);
        UserRegistration newUserRegistrationData = userService.updateUser(userRegistration);
        return new ResponseEntity<>(newUserRegistrationData, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
      return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
