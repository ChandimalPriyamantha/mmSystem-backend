package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MedicalDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.MedicalRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.MedicalEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class MedicalManageService {

    @Autowired
    MedicalRepo medicalRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ResponseDTO responseDTO;
    public ResponseDTO getAllMedicals(){
        List<MedicalEntity> medicalEntities = medicalRepo.findAll();
        if (medicalEntities.isEmpty()){
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Medicals not found!");
        }else {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(modelMapper.map(medicalEntities, new TypeToken<ArrayList<MedicalDTO>>(){}.getType()));
            responseDTO.setMessage("Medicals found!");
        }
        return responseDTO;
    }
    public ResponseDTO insertMedicalsAsBulk(List<MedicalDTO> medicalDTOS){
        List<MedicalEntity> medicalsAsBulk = modelMapper.map(medicalDTOS,new TypeToken<ArrayList<MedicalEntity>>(){}.getType());
        try {
            medicalRepo.saveAll(medicalsAsBulk);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(medicalDTOS);
            responseDTO.setMessage("Medicals have been inserted");
        }catch (Exception e){
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(medicalDTOS);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
    public void insertAMedical(MedicalDTO medicalDTO){

    }
    public void getAMedicalById(int id){

    }
    public void updateAMedicalById(MedicalDTO medicalDTO){

    }
    public void deleteAMedicalById(int id){

    }

}
