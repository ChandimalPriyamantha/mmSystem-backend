package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.EvaluationCriteriaLecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;



public interface EvaluationCriteriaRepository extends JpaRepository<EvaluationCriteriaLecture, Integer> {

    Page<EvaluationCriteriaLecture> findEvaluationCriteriaByCourseId(@RequestParam("courseId") String courseId, Pageable pageable);

    @Query("SELECT s FROM EvaluationCriteriaLecture s WHERE s.courseId = :courseId AND " +
            "s.assessmentType = :assignmentType")
    Page<EvaluationCriteriaLecture> findEvaluationCriteriaByByCourseIdAndAndAssignmentType(String courseId, String assignmentType,Pageable pageable);
}
