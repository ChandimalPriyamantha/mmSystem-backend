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
    public ResponseEntity saveLecturerDetails(@RequestBody LecturersRegDTO lecturerRegDetails){
        ResponseDTO response=lecturersRegService.saveLecturerDetails(lecturerRegDetails);
        if(response.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        else
            return new ResponseEntity(response,HttpStatus.NOT_FOUND);

    }

    @GetMapping("get/alllecturersdetails")
    public ResponseEntity getAllLecDetails(){
        ResponseDTO response=lecturersRegService.getAllLecturers();
        if(response.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        else
            return new ResponseEntity(response,HttpStatus.NOT_FOUND);
    }

    @PutMapping("edit/alecdetails")
    public ResponseEntity editLecturerDetails(@RequestBody LecturersRegDTO lecturersRegDTO)
    {
        ResponseDTO response=lecturersRegService.editLecturerDetails(lecturersRegDTO);
        if(response.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        else
            return new ResponseEntity(response,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/deleteById/{id}")
    public ResponseEntity deleteLecById(@PathVariable int id)
    {
        ResponseDTO response=lecturersRegService.deleteLecByID(id);
        if(response.getCode().equalsIgnoreCase(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        else
            return new ResponseEntity(response,HttpStatus.NOT_FOUND);
    }

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
