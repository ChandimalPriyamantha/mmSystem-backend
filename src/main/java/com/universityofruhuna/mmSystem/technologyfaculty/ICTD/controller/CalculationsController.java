package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CalculationsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.CalculationsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CalculationsDTO> getMarkCalculations(@PathVariable String course_id)
    {
       return calculationsService.getMarksCalculations(course_id);
    }
}
