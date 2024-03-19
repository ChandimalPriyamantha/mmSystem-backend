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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String student_id;

    private String course_id;

    private String level;

    private String semester;

    private double overall_score;

    private String grade;

    @Autowired
    private StudentMarksService studentMarksService;

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/GetMarksByLS/{level},{semester}")
    public List<StudentMarksDTO> getStudentMarksByLevelSemester(@PathVariable String level, @PathVariable String semester)
    {
        return studentMarksService.findStudentMarksByLevelSem(level,semester);
    }



    @PutMapping("/EditMarksForm/")
    public ResponseEntity editMarksById(@RequestBody StudentMarksDTO studentMarksDTO){
        String Response=studentMarksService.editMarks(studentMarksDTO);
        if (Response.equals(VarList.RIP_SUCCESS)){
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setMessage("Successfully Updated!");
            responseDTO.setContent(studentMarksDTO);

            return new ResponseEntity(studentMarksDTO, HttpStatus.ACCEPTED);

        }else {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setMessage("No Data Found for Update!");
            responseDTO.setContent(studentMarksDTO);

            return new ResponseEntity(studentMarksDTO, HttpStatus.NOT_FOUND);
        }



    }

    @GetMapping("/getCourseCodeOverallScoreById/{id}")
    public List<StudentMarksDTO> getCourseCodeOverallScoreById(@PathVariable String id)
    {
        List<StudentMarksDTO> studentsMarksList=studentMarksService.getMarksforCourseById(id);

        return studentsMarksList;
    }





}
