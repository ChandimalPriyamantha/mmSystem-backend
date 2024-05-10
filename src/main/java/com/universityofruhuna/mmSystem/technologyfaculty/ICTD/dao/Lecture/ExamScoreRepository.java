package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.ExamScore;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface can be used to get api from exam table.
public interface ExamScoreRepository extends JpaRepository<ExamScore, Long> {

}
