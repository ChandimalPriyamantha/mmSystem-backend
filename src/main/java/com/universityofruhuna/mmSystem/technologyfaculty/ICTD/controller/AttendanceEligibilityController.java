package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AttendanceEligibilityDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AttendanceEligibilityService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/attendanceEligibility")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceEligibilityController
{
    @Autowired
    private AttendanceEligibilityService attendanceEligibilityService;

    @GetMapping("/getAttendanceEligibilityByStuIdCourseId/{course_id},{student_id}")
    public ResponseEntity getAttendanceEligibilityByStuIdCourseId(@PathVariable String course_id,@PathVariable String student_id)
    {
        AttendanceEligibilityDTO list=attendanceEligibilityService.getAttendanceEligibilityByStuIdCourseId(course_id,student_id);

        System.out.println(list);
        if(list==null)
        {
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        else
        {
            return  new ResponseEntity(list,HttpStatus.OK);
        }

    }

    @GetMapping("getallattendance")
    public ResponseEntity<ResponseDTO> getAllAttendance(){}

    @PostMapping("insertbulkattendance")
    public ResponseEntity insertBulkAttendance(@RequestBody List<AttendanceEligibilityDTO> attendanceEligibilityDTOS){}

    @PostMapping("insertoneattendance")
    public ResponseEntity insertAAttendance(@RequestBody AttendanceEligibilityDTO attendanceEligibilityDTO){

    }

    @GetMapping("getattendance/{id}")
    public ResponseEntity getAAttendanceById(@PathVariable int id){}

    @PutMapping("updateattendance/{id}")
    public ResponseEntity updateAAttendanceById(@RequestBody AttendanceEligibilityDTO attendanceEligibilityDTO){}

    @DeleteMapping("delattendance/{id}")
    public ResponseEntity deleteAAttendanceById(@PathVariable int id){
    }
}
