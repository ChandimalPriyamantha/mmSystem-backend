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
import java.util.stream.Collectors;

@Service
@Transactional
public class LectureScoreService {

    private ExamScoreRepository examScoreRepository;
    private LectureStudentStateUpdateService lectureStudentStateUpdateService;

    // Initialization examRepository object
    @Autowired
    public LectureScoreService(ExamScoreRepository examScoreRepository, LectureStudentStateUpdateService lectureStudentStateUpdateService) {
        this.examScoreRepository = examScoreRepository;
        this.lectureStudentStateUpdateService = lectureStudentStateUpdateService;
    }

    // Score Feeding method to add new score
    public void feedScores(AddScoreRequest addScoreRequest){

        // create ExamScore object to feed score
        ExamScore examScore = new ExamScore();
        examScore.setStudentID(addScoreRequest.getStudentID());
        examScore.setCourseID(addScoreRequest.getCourseID());
        examScore.setYear(addScoreRequest.getYear());
        examScore.setAssignmentType(addScoreRequest.getAssignmentType());
        examScore.setAssignmentScore(addScoreRequest.getAssignmentScore());
        examScore.setLevel(addScoreRequest.getLevel());
        examScore.setSemester(addScoreRequest.getSemester());
        examScore.setEvaluationCriteriaId(addScoreRequest.getEvaluationCriteriaId());
        // save record in mark table
        examScoreRepository.save(examScore);

    }

    // to save data come from CSV file into mark table
    public void saveCsvData(MultipartFile file) throws Exception{
        List<ExamScore> csvRecords = new ArrayList<>();
        // Read the CSV file and parse its data
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Skip the header if present
            List<String> lines = br.lines().skip(1).collect(Collectors.toList());

            // Process each line in the CSV
            for (String line : lines) {
                String[] fields = line.split(","); // Assuming CSV fields are comma-separated

                // Create ExamScore object from CSV data
                ExamScore examScore = new ExamScore();
                examScore.setStudentID(fields[0]);
                examScore.setCourseID(fields[1]);
                examScore.setYear(fields[2]);
                examScore.setLevel(fields[3]);
                examScore.setSemester(fields[4]);
                examScore.setAssignmentType(fields[5]);
                examScore.setAssignmentScore(fields[6]);
                examScore.setEvaluationCriteriaId(fields[7]);

                // Add the ExamScore object to the list
                csvRecords.add(examScore);
                // Update state of students
                lectureStudentStateUpdateService.updateStudentState(examScore.getCourseID(), examScore.getAssignmentType(),examScore.getStudentID());
            }

            // Save all records in the list to the database
            examScoreRepository.saveAll(csvRecords);
        } catch (Exception e) {
            throw new Exception("Failed to process CSV file: " + e.getMessage());
        }
    }


}
