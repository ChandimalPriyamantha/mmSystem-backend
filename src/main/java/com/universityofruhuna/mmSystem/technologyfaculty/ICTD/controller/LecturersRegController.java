package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.LecturersRegDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.LecturersRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("allLecids")
    public ResponseEntity getAllLecIds(){
        ResponseDTO response = lecturersRegService.getAllLecId();
        if(response.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        else
            return new ResponseEntity(response,HttpStatus.NOT_FOUND);
    }
}
