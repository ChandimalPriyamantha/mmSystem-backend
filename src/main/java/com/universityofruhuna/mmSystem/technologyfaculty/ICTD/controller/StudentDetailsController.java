package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentDetailsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/studentdetails")
public class StudentDetailsController {

    @Autowired
    private StudentDetailsService studentDetailsService;

    @PostMapping("savestudentsdetails")
    public void saveStudentDetails(@RequestBody List<StudentDetailsDTO> studentDetailsList){
        studentDetailsService.SaveStudentDetails(studentDetailsList);
    }


}
