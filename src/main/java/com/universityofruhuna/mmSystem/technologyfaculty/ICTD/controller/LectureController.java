package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.ExamScore;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel.AddScoreRequest;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.LectureScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/lecture")
public class LectureController {

    private LectureScoreService lectureScoreService;

    @Autowired
    public LectureController(LectureScoreService lectureScoreService) {
        this.lectureScoreService = lectureScoreService;
    }

    @PostMapping("add/score")
    public void addScore(@RequestBody AddScoreRequest addScoreRequest){
        lectureScoreService.feedScores(addScoreRequest);
    }


    @GetMapping("get/score")
    public List<ExamScore> getAllScore(){
        return lectureScoreService.getAllScore();
    }

    @PutMapping("edit/score/{id}")
   public void editScore(@RequestBody ExamScore examScore)
    {
        lectureScoreService.editScore(examScore);
    }


    @GetMapping("get/scorebyID/{id}")
    public Optional<ExamScore> getScoreByID(@PathVariable int id){
        return lectureScoreService.getScoreByID(id);
    }

}