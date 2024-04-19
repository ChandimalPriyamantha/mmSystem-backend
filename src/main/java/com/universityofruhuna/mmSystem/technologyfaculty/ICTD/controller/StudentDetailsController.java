package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentDetailsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/studentdetails")
public class StudentDetailsController {

    @Autowired
    private StudentDetailsService studentDetailsService;

    @GetMapping("getallstudentsdetails")
    public ResponseEntity<ResponseDTO> getAllStudentsDetails(){}

    @PostMapping("insertbulkstudentsdetails")
    public ResponseEntity saveStudentDetails(@RequestBody List<StudentDetailsDTO> studentDetailsDTOS){}

    @PostMapping("insertastudent")
    public ResponseEntity insertAStudentDetails(@RequestBody StudentDetailsDTO studentDetailsDTO){

    }

    @GetMapping("getastudent/{id}")
    public ResponseEntity getAStudentDetailsById(@PathVariable int id){}

    @PutMapping("updateastudent/{id}")
    public ResponseEntity updateAStudentDetailsById(@RequestBody StudentDetailsDTO studentDetailsDTO){}

    @DeleteMapping("delastudent/{id}")
    public ResponseEntity deleteAStudentById(@PathVariable int id){}






}
