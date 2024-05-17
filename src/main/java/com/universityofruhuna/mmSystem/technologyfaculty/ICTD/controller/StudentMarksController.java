package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentMarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentMarksService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/studentMarks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentMarksController
{


    @Autowired
    private StudentMarksService studentMarksService;


    @GetMapping("/GetMarksByLS/{level},{semester}")
    public ResponseEntity getStudentMarksByLevelSemester(@PathVariable String level, @PathVariable String semester)
    {
        ResponseDTO response=studentMarksService.findStudentMarksByLevelSem(level,semester);
        if(response.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(response,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/GetApprovedMarksByLS/{level}/{semester}/{approved_level}/{department_id}")
    public ResponseEntity GetApprovedMarksByLS(@PathVariable String level, @PathVariable String semester,@PathVariable String approved_level,@PathVariable String department_id)
    {
        ResponseDTO responseDTO=studentMarksService.findApprovedStudentMarksByLevelSem(level,semester,approved_level,department_id);
        if (responseDTO.getCode().equals(VarList.RIP_SUCCESS)) {
            return new ResponseEntity(responseDTO,HttpStatus.OK);
        }
        else
            return new ResponseEntity(responseDTO,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getCourseCodeOverallScoreById/{id}")
    public ResponseEntity getCourseCodeOverallScoreById(@PathVariable String id)
    {
        ResponseDTO response=studentMarksService.getMarksforCourseById(id);

        if(response.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(response,HttpStatus.OK);
        }
        else
             return new ResponseEntity(response,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getStudentMarksbyCourse/{course_id}")
    public ResponseEntity getMarksByC(@PathVariable String course_id)
    {
        ResponseDTO response=studentMarksService.getMarksbyC(course_id);

        if(response.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(response,HttpStatus.OK);
        }
        else
            return new ResponseEntity(response,HttpStatus.OK);
    }

    @GetMapping("/getStudentMarksbySC/{course_id},{student_id}")
    public ResponseEntity getMarksBySC(@PathVariable String course_id,@PathVariable String student_id)
    {
        ResponseDTO response=studentMarksService.getMarksbySC(course_id,student_id);
        if(response.getCode().equals(VarList.RIP_NO_DATA_FOUND))
        {
            return new ResponseEntity(response,HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity(response,HttpStatus.OK);
    }
}
