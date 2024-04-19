package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CourseNameIdDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/getcidcnamebyls/{level},{semester}")
    public ResponseEntity getCidCnameByLS(@PathVariable int level, @PathVariable int semester){

        List<CourseDTO> courseDTOList = courseService.findCidCnameByLS(level, semester);
        List<CourseNameIdDTO> courseNameIdDTOs = new ArrayList<>();

        for (CourseDTO courseDTO : courseDTOList) {
            CourseNameIdDTO courseNameIdDTO = new CourseNameIdDTO();
            courseNameIdDTO.setCourse_name(courseDTO.getCourse_name());
            courseNameIdDTO.setCourse_id(courseDTO.getCourse_id());
            courseNameIdDTOs.add(courseNameIdDTO);
        }

        // Check if courseNameIdDTOs is empty after populating it
        if (courseNameIdDTOs.isEmpty()) {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setMessage("No Approved Courses");
            responseDTO.setContent(courseNameIdDTOs);
            return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(courseNameIdDTOs, HttpStatus.OK);
        }
    }

    @GetMapping("getallcourses")
    public ResponseEntity<ResponseDTO> getAllCourses(){
//        ResponseDTO allCourses
    }

    @PostMapping("insertbulkcourses")
    public  ResponseEntity insertBulkCourses(@RequestBody List<CourseDTO> courseDTOS){

    }

    @PostMapping("insertacourse")
    public  ResponseEntity insertBulkCourses(@RequestBody CourseDTO courseDTO){

    }

    @GetMapping("getacourse/{id}")
    public ResponseEntity getACourseById(@PathVariable int id){

    }

    @PutMapping("updateacourse/{id}")
    public ResponseEntity updateACourseById(@RequestBody CourseDTO courseDTO){

    }

    @DeleteMapping("delacourse/{id}")
    public ResponseEntity deletaCourseByIb(@PathVariable int id){

    }

}
