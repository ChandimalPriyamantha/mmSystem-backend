package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.EvaluationCriteriaDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.EvaluationCriteriaRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.EvaluationCriteria;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EvaluationCriteriaService
{

    @Autowired
    private EvaluationCriteriaRepo evaluationCriteriaRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDTO responseDTO;



    public ResponseDTO getEvaluationCriteria(String course_id)
    {
        List<EvaluationCriteria> list=evaluationCriteriaRepo.getEvaluationCriteria(course_id);
        if(list.isEmpty())
        {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("No data found");

            return responseDTO;
        }

        else
        {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(modelMapper.map(list,new TypeToken<ArrayList<EvaluationCriteriaDTO>>(){}.getType()));
            responseDTO.setMessage("Successfull");
        }
       return  responseDTO;
    }

    public ResponseDTO insertEvCriteria(List<EvaluationCriteriaDTO> evaluationCriteriaDTOList){

        List<EvaluationCriteria> EvCriteriaInsert = modelMapper.map(evaluationCriteriaDTOList, new TypeToken<ArrayList<EvaluationCriteria>>(){}.getType());
        try{
            evaluationCriteriaRepo.saveAll(EvCriteriaInsert);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(evaluationCriteriaDTOList);
            responseDTO.setMessage("Data have been inserted!");

        }catch (Exception e){
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(evaluationCriteriaDTOList);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
