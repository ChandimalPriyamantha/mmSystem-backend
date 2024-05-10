package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.EvaluationCriteriaLecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;



public interface EvaluationCriteriaRepository extends JpaRepository<EvaluationCriteriaLecture, Integer> {

    Page<EvaluationCriteriaLecture> findEvaluationCriteriaByCourseId(@RequestParam("courseId") String courseId, Pageable pageable);
}
