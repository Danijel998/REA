package com.example.RealEstateAgency.Entity;

import com.example.RealEstateAgency.Enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REGISTERED_USER")
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "ROLE", nullable = false)
    private String role = "ROLE_USER";
    @Column(name = "REA_VAT", nullable = false)
    private Long realEstateAgencyIdentificationNumber;
}
