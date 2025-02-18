package com.example.RealEstateAgency.Service;


import com.example.RealEstateAgency.DTO.RealEstateDTO;
import com.example.RealEstateAgency.Entity.RealEstate;
import com.example.RealEstateAgency.Mapper.RealEstateMapper;
import com.example.RealEstateAgency.Repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RealEstateService {

    @Autowired
    RealEstateRepository realEstateRepository;
    @Autowired
    RealEstateMapper realEstateMapper;

    //CREATE
    public RealEstateDTO saveRealEstate(RealEstateDTO realEstateDTO) {
        RealEstateMapper mapper = new RealEstateMapper();
        RealEstate realEstate = realEstateMapper.mapRealEstateDTOToRealEstate(realEstateDTO);
         realEstateRepository.save(realEstate);
        return mapper.mapRealEstateToRealEstateDTO(realEstate);
    }

    //READ ALL
    public List<RealEstateDTO> getAllRealEstates() {
        RealEstateMapper mapper = new RealEstateMapper();
        List<RealEstate> realEstate = realEstateRepository.findAll();
        return realEstate.stream()
                .map(mapper::mapRealEstateToRealEstateDTO)
                .collect(Collectors.toList());
    }

    //READ
    public RealEstateDTO getRealEstate(String realEstateName) {
        RealEstateMapper mapper = new RealEstateMapper();
        RealEstate realEstate = realEstateRepository.findByRealEstateName(realEstateName)
                .orElseThrow(() -> new RuntimeException("Real estate with name" + realEstateName + "doesnt exist"));
        return mapper.mapRealEstateToRealEstateDTO(realEstate);
    }

    //UPDATE
    public RealEstateDTO updateRealEstate(Long id, RealEstateDTO realEstateDTO) {
        RealEstateMapper mapper = new RealEstateMapper();
        RealEstate realEstate = (realEstateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Real estate with id: " + id + "doesnt exist,")));

        if (realEstateDTO.getRealEstateNameDTO() != null && !realEstateDTO.getRealEstateNameDTO()
                .equals(realEstate.getRealEstateName())) {
            realEstate.setRealEstateName(realEstateDTO.getRealEstateNameDTO());
        }

        if (realEstateDTO.getRealEstateTypeDTO() != null && !realEstateDTO.getRealEstateTypeDTO()
                .equals(realEstate.getRealEstateType())) {
            realEstate.setRealEstateType(realEstateDTO.getRealEstateTypeDTO());
        }

        if (realEstateDTO.getRealEstateYearDTO() != null && !realEstateDTO.getRealEstateYearDTO()
                .equals(realEstate.getRealEstateYear())) {
            realEstate.setRealEstateYear(realEstate.getRealEstateYear());
        }

        if (realEstateDTO.getRealEstateStatusDTO() != null && !realEstateDTO.getRealEstateStatusDTO()
                .equals(realEstate.getRealEstateStatus())) {
            realEstate.setRealEstateStatus(realEstate.getRealEstateStatus());
        }

        if (realEstateDTO.getRealEstateDescriptionDTO() != null && !realEstateDTO.getRealEstateDescriptionDTO()
                .equals(realEstate.getRealEstateDescription())) {
            realEstate.setRealEstateDescription(realEstate.getRealEstateDescription());
        }

        if (realEstateDTO.getRealEstatePictureDTO() != null && !realEstateDTO.getRealEstatePictureDTO()
                .equals(realEstate.getRealEstatePicture())) {
            realEstate.setRealEstatePicture(realEstate.getRealEstatePicture());
        }

        if (realEstateDTO.getUserIdDTO() != null && !realEstateDTO.getUserIdDTO()
                .equals(realEstate.getUserId())) {
            realEstate.setUserId(realEstate.getUserId());
        }

        if (realEstateDTO.getAgencyIdDTO() != null && !realEstateDTO.getAgencyIdDTO()
                .equals(realEstate.getAgencyID())) {
            realEstate.setAgencyID(realEstate.getAgencyID());
        }

        RealEstate updateRealEstate = realEstateRepository.save(realEstate);
        return mapper.mapRealEstateToRealEstateDTO(updateRealEstate);
    }

    //DELETE
    public void deleteRealEstate(Long realEstateID) {
        RealEstate deleteRealEstate = realEstateRepository.findById(realEstateID)
                .orElseThrow(() -> new RuntimeException("Real estate with id: " + realEstateID + "doesn't exist."));
        realEstateRepository.delete(deleteRealEstate);
        ;
    }

}
