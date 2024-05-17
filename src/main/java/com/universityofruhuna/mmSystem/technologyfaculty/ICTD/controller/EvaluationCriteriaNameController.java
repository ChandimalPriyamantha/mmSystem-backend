package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.EvaluationCriteriaNameDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.EvaluationCriteriaNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/evaluationCriteriaName")
public class EvaluationCriteriaNameController {

    @Autowired
    private EvaluationCriteriaNameService evaluationCriteriaNameService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("insertcriterianame")
    public ResponseEntity insertAEvCriteriaName(@RequestBody List<EvaluationCriteriaNameDTO> evaluationCriteriaNameDTOList){
        ResponseDTO evCriteriaName = evaluationCriteriaNameService.insertEvCriteriaName(evaluationCriteriaNameDTOList);
        if (evCriteriaName.getCode().equals(VarList.RIP_SUCCESS)) return new ResponseEntity(evCriteriaName, HttpStatus.CREATED);
        else return new ResponseEntity(evCriteriaName, HttpStatus.BAD_REQUEST);
    }
}
