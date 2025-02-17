package com.example.RealEstateAgency.Service;


import com.example.RealEstateAgency.DTO.RealEstateDTO;
import com.example.RealEstateAgency.Entity.RealEstate;
import com.example.RealEstateAgency.Mapper.RealEstateMapper;
import com.example.RealEstateAgency.Repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {

    @Autowired
    RealEstateRepository realEstateRepository;

    //CREATE
    public RealEstate saveRealEstate(RealEstateDTO realEstateDTO){
        RealEstateMapper mapper =  new RealEstateMapper();
        return realEstateRepository.save(mapper.mapRealEstateDTOToRealEstate(realEstateDTO));
    }

    //READ ALL
    public List<RealEstate> getAllRealEstates(){
        return realEstateRepository.findAll();
    }

    //READ
    public RealEstate getRealEstate(String realEstateName){
        return realEstateRepository.findByRealEstateName(realEstateName);
    }

    //UPDATE
    public RealEstate updateRealEstate(RealEstate realEstate){
        RealEstate estate = realEstateRepository.findById(realEstate.getRealEstateID()).get();

        if(realEstate.getRealEstateName() != null && !estate.getRealEstateName()
                .equals(realEstate.getRealEstateName())){
            estate.setRealEstateName(realEstate.getRealEstateName());
        }

        if(realEstate.getRealEstateType() != null && !estate.getRealEstateType().equals(realEstate.getRealEstateType())){
            estate.setRealEstateType(realEstate.getRealEstateType());
        }

        if(realEstate.getRealEstateYear() != null && !estate.getRealEstateYear().equals(realEstate.getRealEstateYear())){
            estate.setRealEstateYear(realEstate.getRealEstateYear());
        }

        if(realEstate.getRealEstateStatus() != null && !estate.getRealEstateStatus().equals(realEstate.getRealEstateStatus())){
            estate.setRealEstateStatus(realEstate.getRealEstateStatus());
        }

        if(realEstate.getRealEstateDescription() != null && !estate.getRealEstateDescription().equals(realEstate.getRealEstateDescription())){
            estate.setRealEstateDescription(realEstate.getRealEstateDescription());
        }

        if(realEstate.getRealEstatePicture() != null && !estate.getRealEstatePicture().equals(realEstate.getRealEstatePicture())){
            estate.setRealEstatePicture(realEstate.getRealEstatePicture());
        }

        if(realEstate.getUserId() != null && !estate.getUserId().equals(realEstate.getUserId())){
            estate.setUserId(realEstate.getUserId());
        }

        if(realEstate.getAgencyID() != null && !estate.getAgencyID().equals(realEstate.getAgencyID())){
            estate.setAgencyID(realEstate.getAgencyID());
        }

        return realEstateRepository.save(estate);
    }

    //DELETE
    public void deleteRealEstate(Long realEstateID){
        realEstateRepository.deleteById(realEstateID);
    }

}
