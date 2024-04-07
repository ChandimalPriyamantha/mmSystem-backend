package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture.ExamScoreRepository;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.ExamScore;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel.Lecture.AddScoreRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LectureScoreService {

    private ExamScoreRepository examScoreRepository;

    // Initialization examRepository object
    @Autowired
    public LectureScoreService(ExamScoreRepository examScoreRepository) {
        this.examScoreRepository = examScoreRepository;
    }

    // Score Feeding method to add new score
    public void feedScores(AddScoreRequest addScoreRequest){

        ExamScore examScore = new ExamScore();
        examScore.setStudentID(addScoreRequest.getStudentID());
        examScore.setCourseID(addScoreRequest.getCourseID());
        examScore.setYear(addScoreRequest.getYear());
        examScore.setAssignmentType(addScoreRequest.getAssignmentType());
        examScore.setAssignmentScore(addScoreRequest.getAssignmentScore());
        examScore.setLevel(addScoreRequest.getLevel());
        examScore.setSemester(addScoreRequest.getSemester());
        examScoreRepository.save(examScore);

    }
}
