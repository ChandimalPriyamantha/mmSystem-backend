package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentMarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentMarks;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentMarksService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/GetMarksByLS/{level},{semester}")
    public List<StudentMarksDTO> getStudentMarksByLevelSemester(@PathVariable String level, @PathVariable String semester)
    {
        return studentMarksService.findStudentMarksByLevelSem(level,semester);
    }




    @PutMapping("/EditMarksForm")
    public void editMarksById(@RequestBody List<StudentMarksDTO> studentMarksDTO){

        studentMarksService.editMarks(studentMarksDTO);

//        String Response=studentMarksService.editMarks(studentMarksDTO);
//        if (Response.equals(VarList.RIP_SUCCESS)){
//            responseDTO.setCode(VarList.RIP_SUCCESS);
//            responseDTO.setMessage("Successfully Updated!");
//            responseDTO.setContent(studentMarksDTO);
//
//            return new ResponseEntity(studentMarksDTO, HttpStatus.ACCEPTED);
//
//        }else {
//            responseDTO.setCode(VarList.RIP_ERROR);
//            responseDTO.setMessage("No Data Found for Update!");
//            responseDTO.setContent(studentMarksDTO);
//
//            return new ResponseEntity(studentMarksDTO, HttpStatus.NOT_FOUND);
//        }



    }

    @GetMapping("/getCourseCodeOverallScoreById/{id}")
    public ResponseEntity getCourseCodeOverallScoreById(@PathVariable String id)
    {
        List<StudentMarksDTO> studentsMarksList=studentMarksService.getMarksforCourseById(id);

        if(studentsMarksList.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else

            return new ResponseEntity(studentsMarksList,HttpStatus.OK);
    }

    @GetMapping("/getStudentMarksbyCourse/{course_id}")
    public ResponseEntity getMarksByC(@PathVariable String course_id)
    {
        List<StudentMarksDTO> list=studentMarksService.getMarksbyC(course_id);

        if(list.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else

        return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/getStudentMarksbySC/{course_id},{student_id}")
    public ResponseEntity getMarksBySC(@PathVariable String course_id,@PathVariable String student_id)
    {
        StudentMarksDTO list=studentMarksService.getMarksbySC(course_id,student_id);
        if(list==null)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
        return new ResponseEntity(list,HttpStatus.OK);
    }








}
