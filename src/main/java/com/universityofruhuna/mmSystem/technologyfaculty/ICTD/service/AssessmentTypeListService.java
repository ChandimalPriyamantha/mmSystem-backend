package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AssessmentTypeListDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AssessmentTypeListRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AssessmentTypeListEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AssessmentTypeListService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AssessmentTypeListRepo assessmentTypeListRepo;

    @Autowired
    ResponseDTO responseDTO;

    public ResponseDTO NewAssessmentType(AssessmentTypeListDTO assessmentTypeListDTO){
        if (assessmentTypeListDTO == null){
            responseDTO.setMessage(VarList.RIP_ERROR);
            responseDTO.setContent(null);
            responseDTO.setMessage("Empty");
        }else {
            AssessmentTypeListEntity assessmentTypeListEntity = modelMapper.map(assessmentTypeListDTO, AssessmentTypeListEntity.class);
            try{
                assessmentTypeListRepo.save(assessmentTypeListEntity);
                responseDTO.setCode(VarList.RIP_SUCCESS);
                responseDTO.setContent(assessmentTypeListEntity);
                responseDTO.setMessage("New Assessment Type Saved Successfully");
            }catch (Exception e){
                responseDTO.setCode(VarList.RIP_ERROR);
                responseDTO.setContent(assessmentTypeListEntity);
                responseDTO.setMessage("Assessment Type can not be saved ");
            }
        }
        return responseDTO;
    }
}
