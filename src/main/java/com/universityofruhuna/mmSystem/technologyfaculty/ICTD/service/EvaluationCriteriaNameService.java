package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.EvaluationCriteriaNameDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.EvaluationCriteriaNameRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.EvaluationCriteriaNameEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EvaluationCriteriaNameService {
    @Autowired
    private EvaluationCriteriaNameRepo evaluationCriteriaNameRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDTO responseDTO;


    public ResponseDTO insertEvCriteriaName(List<EvaluationCriteriaNameDTO> evaluationCriteriaNameDTOList){
        List<EvaluationCriteriaNameEntity> EvCriteriaNameInsert = modelMapper.map(evaluationCriteriaNameDTOList, new TypeToken<ArrayList<EvaluationCriteriaNameEntity>>(){}.getType());
        try {
            evaluationCriteriaNameRepo.saveAll(EvCriteriaNameInsert);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(evaluationCriteriaNameDTOList);
            responseDTO.setMessage("Data have been inserted!");
        }catch (Exception e){
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(evaluationCriteriaNameDTOList);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

}
