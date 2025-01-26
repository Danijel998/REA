package com.example.RealEstateAgency.Controller;


import com.example.RealEstateAgency.Entity.RealEstateAgency;
import com.example.RealEstateAgency.Service.RealEstateAgencyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/realEstateAgency")
public class RealEstateAgencyController {

    @Autowired
    private RealEstateAgencyService realEstateAgencyService;

    //CREATE
    @PostMapping("/createAgency")
    public ResponseEntity<RealEstateAgency> createRealEstate(@RequestBody RealEstateAgency realEstateAgency){
        RealEstateAgency savedRealEstate = realEstateAgencyService.saveRealEstateAgency(realEstateAgency);
        return new ResponseEntity<>(savedRealEstate, HttpStatus.CREATED);
    }

    //READ
    @GetMapping("/agencyList")
    public ResponseEntity<List<RealEstateAgency>> getAllRealEstateAgency(){
        List<RealEstateAgency> realEstates = realEstateAgencyService.getRealEstateAgency();
        return new ResponseEntity<>(realEstates, HttpStatus.FOUND);
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<RealEstateAgency> updateRealEstateAgency(@PathVariable("id") Long agencyID,
                                                             @RequestBody RealEstateAgency realEstateAgency){
    realEstateAgency.setAgencyID(agencyID);
    RealEstateAgency updateRealEstate = realEstateAgencyService.updateRealEstateAgency(realEstateAgency);
    return new ResponseEntity<>(updateRealEstate, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRealEstateAgency(@PathVariable("id") Long id){
        realEstateAgencyService.deleteUser(id);
        return new ResponseEntity<>("Real Estate successfully deleted", HttpStatus.OK);
    }

}
