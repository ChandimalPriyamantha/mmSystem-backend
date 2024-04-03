package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel.AddScoreRequest;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.LectureScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/lecture")
public class LectureController { // Controller class to handle all function regarding the lecture

    private LectureScoreService lectureScoreService;

    // initialize lectureScoreService object.
    @Autowired
    public LectureController(LectureScoreService lectureScoreService) {
        this.lectureScoreService = lectureScoreService;
    }

    // This method can be used to create API endpoint to feed students' score.
    @PostMapping("add/score")
    public void addScore(@RequestBody AddScoreRequest addScoreRequest){
        lectureScoreService.feedScores(addScoreRequest);
    }
}
