package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentMarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentMarks;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentMarksService;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studentMarks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentMarksController
{
    @Id
    private int id;

    private String student_id;

    private String course_id;

    private String level;

    private String semester;

    private double overall_score;

    private String grade;

    @Autowired
    private StudentMarksService studentMarksService;



    @GetMapping("/GetMarksByLS/{level},{semester}")
    public List<StudentMarksDTO> getStudentMarksByLevelSemester(@PathVariable String level, @PathVariable String semester)
    {
        return studentMarksService.findStudentMarksByLevelSem(level,semester);
    }






}
