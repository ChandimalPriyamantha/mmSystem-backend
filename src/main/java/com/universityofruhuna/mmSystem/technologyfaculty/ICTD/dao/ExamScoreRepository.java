package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.ExamScore;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentMarks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ExamScoreRepository extends JpaRepository<ExamScore, Long> {

    @Query(nativeQuery = true, value = "select * from marks where course_id=course_id")
    List<ExamScore> findStudentMarksByCourseID(@Param("course_id") String course_id);

    @Query(nativeQuery = true, value = "select * from marks where student_id=student_id")
    List<ExamScore> getScoreByStudent_ID(@Param("student_id") String student_id);

}
