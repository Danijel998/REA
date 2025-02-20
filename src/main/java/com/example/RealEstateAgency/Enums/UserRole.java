package com.example.RealEstateAgency.Enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public enum UserRole {

    USER("USER"),
    ADMIN("ADMIN"),
    SUPER_ADMIN("SUPER_ADMIN");

    private String roleName;

    UserRole(String roleName){
        this.roleName = roleName;
    }

    private  String getName(){
        return this.roleName;
    }
}
