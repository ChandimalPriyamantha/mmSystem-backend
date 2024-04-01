package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentRegCoursesDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentRegCoursesServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/studentRegCourses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentRegistedCourseController
{
    private String student_id;

    private String course_id;

    @Autowired
    private StudentRegCoursesServices studentRegCoursesServices;

    @GetMapping("/getStudentsByCourse/{course_id}")
    public List<StudentRegCoursesDTO> getStudentsByCourse(@PathVariable String course_id)
    {
        return studentRegCoursesServices.getStudentsByCourseCode(course_id);
    }

}
