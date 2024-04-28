package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.EvaluationCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;



public interface EvaluationCriteriaRepository extends JpaRepository<EvaluationCriteria, Integer> {

    Page<EvaluationCriteria> findEvaluationCriteriaByCourseId(@RequestParam("courseId") String courseId, Pageable pageable);
}
