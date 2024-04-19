package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MedicalDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.MedicalManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/medicalmng")
public class MedicalController {

    @Autowired
    MedicalManageService medicalManageService;

    @GetMapping("getallmedicals")
    public ResponseEntity<ResponseDTO> getAllMedicals(){
        ResponseDTO allmedicals = medicalManageService.getAllMedicals();
        if (allmedicals.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity<>(allmedicals, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(allmedicals,HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("insertbulkmedical")
    public ResponseEntity insertMedicalsAsBulk(@RequestBody List<MedicalDTO> medicalDTOS){
        ResponseDTO medicalsAsBulk = medicalManageService.insertMedicalsAsBulk(medicalDTOS);
        if (medicalsAsBulk.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(HttpStatus.CREATED);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("insertamedical")
    public ResponseEntity insertAMedical(@RequestBody MedicalDTO medicalDTO){
      ResponseDTO insertOneMedical = medicalManageService.insertAMedical(medicalDTO);
      if (insertOneMedical.getCode().equals(VarList.RIP_SUCCESS)){
          return new ResponseEntity(HttpStatus.CREATED);
      }else {
          return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
    }

    @GetMapping("getamedical/{id}")
    public ResponseEntity getAMedicalById(@PathVariable int id){
        ResponseDTO getAMedicalById =medicalManageService.getAMedicalById(id);
        if (getAMedicalById.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateamedical/{id}")
    public ResponseEntity updateAMedicalById(@RequestBody MedicalDTO medicalDTO){
        ResponseDTO updateOneMedicalById = medicalManageService.updateAMedicalById(medicalDTO);
        if (updateOneMedicalById.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("delamedical/{id}")
    public ResponseEntity deleteAMedicalById(@PathVariable int id){
        ResponseDTO deleteOneMedicalById = medicalManageService.deleteAMedicalById(id);
        if (deleteOneMedicalById.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
