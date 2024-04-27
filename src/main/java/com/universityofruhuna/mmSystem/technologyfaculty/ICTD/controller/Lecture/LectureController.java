package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller.Lecture;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel.Lecture.AddScoreRequest;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Lecture.LectureScoreService;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Lecture.LectureStudentStateUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/lecture")
public class LectureController { // Controller class to handle all function regarding the lecture

    private LectureScoreService lectureScoreService;
    private LectureStudentStateUpdateService lectureStudentStateUpdateService;

    private AddScoreRequest addScoreRequest;
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

    @PostMapping("/upload/studentScore")
    public ResponseEntity<?> uploadCsv(@RequestParam("file") MultipartFile file){
        try{
           lectureScoreService.saveCsvData(file);
           return ResponseEntity.ok("CSV data uploaded successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "Filed to upload CSV data: " + e.getMessage()
            );
        }
    }
}
