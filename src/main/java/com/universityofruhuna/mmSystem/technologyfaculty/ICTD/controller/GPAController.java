package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.GPADTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.GPA;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.GPAService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/gpa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GPAController
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String student_id;

    private String acadamic_year;

    private int level;

    private int semester;

    private double sgpa;

    private double cgpa;

    @Autowired
    private GPAService gpaService;

    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/GetGPAByStudent_Id/{student_id}")
    public List<GPADTO> GetGPAByStudent_Id(@PathVariable String student_id)
    {
       return gpaService.getGPAByStID(student_id);

    }



}
