package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.ExamScoreRepository;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.ExamScore;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel.AddScoreRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LectureScoreService {

    private ExamScoreRepository examScoreRepository;

    @Autowired
    public LectureScoreService(ExamScoreRepository examScoreRepository) {
        this.examScoreRepository = examScoreRepository;
    }

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

    public List<ExamScore> getAllScore(){
        return examScoreRepository.findAll();
    }


    public List<ExamScore> getAllScoreByCourseId(String course_id){
        return examScoreRepository.findStudentMarksByCourseID(course_id);
    }

    public void editScore( ExamScore examScore)
    {
        examScoreRepository.save(examScore);
    }

    public Optional<ExamScore> getScoreByID(int id)
    {
        return examScoreRepository.findById((long) id);
    }



    public List<ExamScore> getScoreByStudent_ID(String student_id)
    {
        return examScoreRepository.getScoreByStudent_ID(student_id);
    }
}
