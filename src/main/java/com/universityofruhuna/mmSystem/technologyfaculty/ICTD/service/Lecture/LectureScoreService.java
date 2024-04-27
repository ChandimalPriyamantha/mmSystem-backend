package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture.ExamScoreRepository;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.ExamScore;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel.Lecture.AddScoreRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        examScore.setAssignmentName(addScoreRequest.getAssignmentName());
        examScoreRepository.save(examScore);

    }

    public void saveCsvData(MultipartFile file) throws Exception{
        List<ExamScore> csvRecords = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        while((line = br.readLine()) != null){
            String[] data = line.split(",");
            ExamScore record = new ExamScore();
            record.setStudentID(data[0]);
//            record.setCourseID(addScoreRequest.getCourseID());
//            record.setAssignmentType(addScoreRequest.getAssignmentType());
            record.setAssignmentScore(data[1]);
//            record.setYear(addScoreRequest.getYear());
//            record.setLevel(addScoreRequest.getLevel());
//            record.setSemester(addScoreRequest.getSemester());
//            record.setAssignmentName(addScoreRequest.getAssignmentName());

            csvRecords.add(record);

        }

        br.close();
        examScoreRepository.saveAll(csvRecords);

    }
}
