package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/findCoursesByDepartmentLevelSemester/{department_id}/{level}/{semester}/{approval_level}")
    public List<CourseDTO> findCoursesByDepartmentLevelSemester(@PathVariable String department_id ,@PathVariable int level, @PathVariable int semester, @PathVariable String approval_level){
        return courseService.findCoursesByDepartmentLevelSemester(department_id,level,semester,approval_level);
    }

    @GetMapping("/findAllCourses")
    public List<CourseDTO> findAllCourses(){
        return courseService.getAllCourses();
    }



}
