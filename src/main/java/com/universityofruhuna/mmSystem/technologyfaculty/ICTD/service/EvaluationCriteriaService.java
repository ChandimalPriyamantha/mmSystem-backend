package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.EvaluationCriteriaDTO;
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

    public List<EvaluationCriteriaDTO> getEvaluationCriteria(String course_id)
    {
       return modelMapper.map(evaluationCriteriaRepo.getEvaluationCriteria(course_id),new TypeToken<ArrayList<EvaluationCriteriaDTO>>(){}.getType()) ;
    }
}
