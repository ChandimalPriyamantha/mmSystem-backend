package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.MarksEntity;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.MarksService;
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
import java.util.Optional;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/StudentAssessment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarksController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String student_id;
    private String course_id;
    private String academic_year;
    private String level;
    private String semester;
    private String Assignment_type;
    private String Assignment_score;
    @Autowired
    private MarksService marksService;



    @GetMapping("get/score")
    public List<MarksDTO> getAllScore(){
       return marksService.getAllScore();
    }

    @GetMapping("get/scoreByCourseId/{course_id}")
    public List<MarksDTO> getAllScoreByCourseId(@PathVariable String course_id){
        return marksService.getAllScoreByCourseId(course_id);
    }

    @PutMapping("edit/score/{id}")
    public void editScore(@RequestBody MarksDTO marksDTO)
    {
        marksService.editScore(marksDTO);
    }


    @GetMapping("get/scorebyID/{id}")
    public Optional<MarksEntity> getScoreByID(@PathVariable int id){
        return marksService.getScoreByID(id);
    }

    @GetMapping("get/scorebyStudentID/{student_id}")
    public List<MarksDTO> getScoreByStudent_ID(@PathVariable String student_id){
        return marksService.getScoreByStudent_ID(student_id);


    }

    @GetMapping("get/scorebyStuIDCourseID/{course_id},{student_id}")
    public ResponseEntity getScoreByStudent_ID(@PathVariable String course_id, @PathVariable String student_id){

        List<MarksDTO> list=marksService.getScoreByStuIDCourseID(course_id,student_id);

        if(list.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else

        return new ResponseEntity(list,HttpStatus.OK);


    }


    @GetMapping("get/scorebyLS/{level},{semester}")
    public ResponseEntity getScoreByLS(@PathVariable String level,@PathVariable String semester){
        List<MarksDTO> list= marksService.getScoreByLS(level,semester);

        if(list.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else

            return new ResponseEntity(list,HttpStatus.OK);

    }
}
