package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.LecturersRegDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.LecturersRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/lecreg")
public class LecturersRegController {

    @Autowired
    LecturersRegService lecturersRegService;

    @PostMapping("savelecdetails")
    public void saveLecturerDetails(@RequestBody LecturersRegDTO lecturerRegDetails){
        lecturersRegService.saveLecturerDetails(lecturerRegDetails);
    }

    @GetMapping("get/alllecturersdetails")
    public List<LecturersRegDTO> getAllLecDetails(){
        return lecturersRegService.getAllLecturers();
    }

    @PutMapping("edit/alecdetails/{id}")
    public void editLecturerDetails(@RequestBody LecturersRegDTO lecturersRegDTO){lecturersRegService.editLecturerDetails(lecturersRegDTO);}

}