package com.example.RealEstateAgency.Entity;


import com.example.RealEstateAgency.Enums.RealEstateStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RE_ID")
    private Long realEstateID;
    @Column(name = "RE_NAME")
    private String realEstateName;
    @Column(name = "RE_TYPE")
    private String realEstateType;
    @Column(name = "RE_YEAR")
    private LocalDate realEstateYear;
    @Column(name = "RE_STATUS")
    private RealEstateStatus realEstateStatus = RealEstateStatus.ACTIVE;
    @Column(name = "RE_DESC")
    private String realEstateDescription;
    @Column(name = "RE_PICTURE")
    private String realEstatePicture;

   // @Column(name = "RE_AGENT")
    @ManyToOne
    @JoinColumn(name = "AGENT_USERNAME" ,referencedColumnName = "USERNAME")
    private UserRegistration realEstateAgent;

    //@Column(name = "AGN_VAT_NUMBER")
    @ManyToOne
    @JoinColumn(name = "AGENCY_VAT", referencedColumnName = "AGN_VAT_NUMBER")
    private RealEstateAgency realEstateAgency;

}
