package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CourseNameIdDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/courses")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CourseController {

    private String course_id;
    private String course_name;
    private int hours;
    private String type;
    private double credit;
    private String department_id;
    private int level;
    private int semester;

    @Autowired
    private CourseService courseService;

    @GetMapping("/getcidcnamebyls/{level},{semester}")
    public List<CourseNameIdDTO> getCidCnameByLS(@PathVariable int level, @PathVariable int semester){
       List<CourseDTO> list  = courseService.findCidCnameByLS(level,semester);
       List<CourseNameIdDTO> courseNameIdDTOs = new ArrayList<>();


        for (CourseDTO courseDTO : list) {
            CourseNameIdDTO courseNameIdDTO = new CourseNameIdDTO();
            courseNameIdDTO.setCourse_name(courseDTO.getCourse_name());
            courseNameIdDTO.setCourse_id(courseDTO.getCourse_id());
            courseNameIdDTOs.add(courseNameIdDTO);
        }

        return courseNameIdDTOs;


    }
}
