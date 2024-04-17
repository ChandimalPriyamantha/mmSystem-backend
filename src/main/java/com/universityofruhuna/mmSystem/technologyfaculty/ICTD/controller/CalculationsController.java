package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CalculationsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.CalculationsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/marksCalculations")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalculationsController
{
    @Autowired
    private CalculationsService calculationsService;

    @GetMapping("/getMarksCalculation/{course_id}")
    public ResponseEntity getMarkCalculations(@PathVariable String course_id)
    {
        List<CalculationsDTO> list=calculationsService.getMarksCalculations(course_id);
        if(list.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
       return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/getMarksCalculationByStuID/{course_id},{student_id}")
    public ResponseEntity getMarkCalculations(@PathVariable String course_id,@PathVariable String student_id)
    {
        List<CalculationsDTO> list= calculationsService.getMarksCalculations(course_id,student_id);
        if(list.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity(list,HttpStatus.OK);
    }


}
