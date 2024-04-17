package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.EvaluationCriteriaDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.EvaluationCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/evaluationCriteria")
public class EvaluationCriteriaController
{
    @Autowired
    private EvaluationCriteriaService evaluationCriteriaService;

    @GetMapping("/getCriteria/{course_id}")
    public List<EvaluationCriteriaDTO> getEvaluationCriteria(@PathVariable String course_id)
    {
        return evaluationCriteriaService.getEvaluationCriteria(course_id);
    }
}
