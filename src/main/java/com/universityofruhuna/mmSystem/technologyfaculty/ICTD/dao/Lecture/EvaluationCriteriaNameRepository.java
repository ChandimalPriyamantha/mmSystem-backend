package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.EvaluationCriteriaName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;



public interface EvaluationCriteriaNameRepository extends JpaRepository<EvaluationCriteriaName, Integer> {
  Page<EvaluationCriteriaName> findEvaluationCriteriaNameByCourseId(@RequestParam("courseId") String courseId, Pageable pageable);
}
