package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AssessmentTypeListDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AssessmentTypeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/astylist")
public class AssessmentTypeListController {

    @Autowired
    AssessmentTypeListService assessmentTypeListService;

    @PostMapping("savenewasty")
    public ResponseEntity saveNewAssessmentType(@RequestBody AssessmentTypeListDTO assessmentTypeListDTO){
        ResponseDTO responseDTO = assessmentTypeListService.NewAssessmentType(assessmentTypeListDTO);
        if (responseDTO.getCode().equals(VarList.RIP_SUCCESS)) return new ResponseEntity(responseDTO, HttpStatus.CREATED);
        else return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("get/allassessmenttypes")
    public ResponseEntity getAllAssessmentTypes(){
        ResponseDTO responseDTO = assessmentTypeListService.allAssessmentTypes();
        if (responseDTO.getCode().equals(VarList.RIP_SUCCESS)) return new ResponseEntity(responseDTO,HttpStatus.OK);
        else return new ResponseEntity(responseDTO,HttpStatus.NOT_FOUND);
    }
}
