package com.example.RealEstateAgency.Controller;


import com.example.RealEstateAgency.Entity.RealEstate;
import com.example.RealEstateAgency.Service.RealEstateService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("api/advertisement")
public class RealEstateController {

    @Autowired
    RealEstateService realEstateService;

    @PostMapping("/create")
    public ResponseEntity<RealEstate> addRealEstate(RealEstate realEstate){
        RealEstate newRealEstate = realEstateService.saveRealEstate(realEstate);
        return new ResponseEntity<>(newRealEstate, HttpStatus.OK);
    }

    @GetMapping("/realEstateList")
    public ResponseEntity<List<RealEstate>> getAllRealEstates(){
        List<RealEstate> getAllRealEstates = realEstateService.getAllRealEstates();
        return new ResponseEntity<>(getAllRealEstates, HttpStatus.OK);
    }

    @GetMapping("/realEstate/{realEstateName}")
    public ResponseEntity<RealEstate> getRealEstate(@PathVariable("realEstateName") String realEstateName ){
        RealEstate getRealEstate = realEstateService.getRealEstate(realEstateName);
        return new ResponseEntity<>(getRealEstate, HttpStatus.OK);
    }

    @PutMapping("/updateRealEstate/{id}")
    public ResponseEntity<RealEstate> updateRealEstate(@PathVariable("id") Long realEstateID,
                                                       @RequestBody RealEstate realEstate){
        realEstate.setRealEstateID(realEstateID);
        RealEstate newRealEstateData = realEstateService.updateRealEstate(realEstate);
        return new ResponseEntity<>(newRealEstateData, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRealEstate/{id}")
    public void deleteRealEstate(@PathVariable("id")Long id ){
        realEstateService.deleteRealEstate(id);
    }

}
