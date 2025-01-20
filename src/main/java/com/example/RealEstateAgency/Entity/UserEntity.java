package com.example.RealEstateAgency.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String password;

    @JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")
    @ManyToOne
    private Role role;

    @JoinColumn(name = "REA_ID", referencedColumnName = "agencyID")
    @ManyToOne
    private RealEstateAgency realEstateAgency;
}
