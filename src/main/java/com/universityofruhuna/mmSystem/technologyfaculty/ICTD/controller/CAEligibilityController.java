package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.CAEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/CAEligibility")
public class CAEligibilityController {

    @Autowired
    private CAEligibilityService caEligibilityService;

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("ofstudents/{course_id}")
    public ResponseEntity getCAElibility(@PathVariable String course_id){
        ResponseDTO CAEli = caEligibilityService.getCAEliFfSt(course_id);
        if (CAEli.getCode().equals(VarList.RIP_SUCCESS)) return new ResponseEntity(CAEli, HttpStatus.OK);
        else return new ResponseEntity(CAEli,HttpStatus.NOT_FOUND);
    }
}
