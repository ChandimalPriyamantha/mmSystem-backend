package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentDetailsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ResponseDTO> getAllStudentsDetails(){
        ResponseDTO allStudentsD = studentDetailsService.getAllStudentsD();
        if (allStudentsD.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity<>(allStudentsD, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(allStudentsD,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("insertbulkstudentsdetails")
    public ResponseEntity saveStudentDetails(@RequestBody List<StudentDetailsDTO> studentDetailsDTOS){
        ResponseDTO StudentDAsBulk = studentDetailsService.insertStudentDetailsAsBulk(studentDetailsDTOS);
        if (StudentDAsBulk.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(StudentDAsBulk,HttpStatus.CREATED);

        }else{
            return new ResponseEntity(StudentDAsBulk,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("insertastudent")
    public ResponseEntity insertAStudentDetails(@RequestBody StudentDetailsDTO studentDetailsDTO){
        ResponseDTO insertOneStudentD = studentDetailsService.insertAStudentD(studentDetailsDTO);
        if (insertOneStudentD.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(insertOneStudentD,HttpStatus.CREATED);
        }else {
            return new ResponseEntity(insertOneStudentD,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getastudent/{id}")
    public ResponseEntity getAStudentDetailsById(@PathVariable int id){
        ResponseDTO getAStudentDById =studentDetailsService.getAStudentDById(id);
        if (getAStudentDById.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(getAStudentDById,HttpStatus.OK);
        }else {
            return new ResponseEntity(getAStudentDById,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateastudent")
    public ResponseEntity updateAStudentDetailsById(@RequestBody StudentDetailsDTO studentDetailsDTO){
        ResponseDTO updateOneStudentDById = studentDetailsService.updateAStudentDById(studentDetailsDTO);
        if (updateOneStudentDById.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(updateOneStudentDById,HttpStatus.OK);
        }else {
            return new ResponseEntity(updateOneStudentDById,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delastudent/{id}")
    public ResponseEntity deleteAStudentById(@PathVariable int id){
        ResponseDTO deleteOneStudentDById = studentDetailsService.deleteAStudentDById(id);
        if (deleteOneStudentDById.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(deleteOneStudentDById,HttpStatus.OK);
        }else {
            return new ResponseEntity(deleteOneStudentDById,HttpStatus.NOT_FOUND);
        }
    }






}
