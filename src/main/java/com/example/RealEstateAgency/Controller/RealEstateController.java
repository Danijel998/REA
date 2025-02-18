package com.example.RealEstateAgency.Controller;


import com.example.RealEstateAgency.DTO.RealEstateDTO;
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
@RequestMapping("/api/realEstate")
public class RealEstateController {

    @Autowired
    RealEstateService realEstateService;

    @PostMapping(value = "/create")
    public ResponseEntity<RealEstateDTO> addRealEstate(@RequestBody RealEstateDTO realEstateDTO) {
        RealEstateDTO createRealEstate = realEstateService.saveRealEstate(realEstateDTO);
        return new ResponseEntity<>(createRealEstate, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RealEstateDTO>> getAllRealEstates() {
       List<RealEstateDTO> getAllRealEstates = realEstateService.getAllRealEstates();
        return new ResponseEntity<>(getAllRealEstates, HttpStatus.OK);
    }

    @GetMapping("/{realEstateName}")
    public ResponseEntity<RealEstateDTO> getRealEstate(@PathVariable("realEstateName") String realEstateName) {
        RealEstateDTO getRealEstate = realEstateService.getRealEstate(realEstateName);
        return new ResponseEntity<>(getRealEstate, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RealEstateDTO> updateRealEstate(@PathVariable("id") Long realEstateID, @RequestBody RealEstateDTO realEstateDTO) {
        RealEstateDTO newRealEstateData = realEstateService.updateRealEstate(realEstateID, realEstateDTO);
        return new ResponseEntity<>(newRealEstateData, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRealEstate(@PathVariable("id") Long id) {
        realEstateService.deleteRealEstate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
