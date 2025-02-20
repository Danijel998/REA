package com.example.RealEstateAgency.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REAL_ESTATE_AGENCY")
public class RealEstateAgency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agencyID")
    private Long agencyID;
    @Column(name = "AGN_VAT_NUMBER" ,length = 12, unique = true, nullable = false)
    private Long agencyIdentificationNumber;
    @Column(name = "AGN_NAME")
    private String agencyName;
    @Column(name = "AGN_POSTCODE")
    private Integer agencyPostcode;
    @Column(name = "AGN_STREET")
    private String agencyStreet;
    @Column(name = "AGN_CITY")
    private String agencyCity;

}
