package com.example.RealEstateAgency.Security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;
    private String error;

}
