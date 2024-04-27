package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller.Lecture;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel.Lecture.AddScoreRequest;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Lecture.LectureScoreService;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Lecture.LectureStudentStateUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/lecture")
public class LectureController { // Controller class to handle all function regarding the lecture

    private LectureScoreService lectureScoreService;
    private LectureStudentStateUpdateService lectureStudentStateUpdateService;

    // initialize lectureScoreService object.
    @Autowired
    public LectureController(LectureScoreService lectureScoreService, LectureStudentStateUpdateService lectureStudentStateUpdateService) {
        this.lectureScoreService = lectureScoreService;
        this.lectureStudentStateUpdateService = lectureStudentStateUpdateService;
    }

    @PutMapping("update/studentState")
    public void updateStudentState(@RequestParam String courseID, @RequestParam String assignmentType, @RequestParam String studentId) throws Exception {

        lectureStudentStateUpdateService.updateStudentState(courseID,assignmentType,studentId);
    }
    // This method can be used to create API endpoint to feed students' score.
    @PostMapping("add/score")
    public void addScore(@RequestBody AddScoreRequest addScoreRequest){
        lectureScoreService.feedScores(addScoreRequest);
    }
}
