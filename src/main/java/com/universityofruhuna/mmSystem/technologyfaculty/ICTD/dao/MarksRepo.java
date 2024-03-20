package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.ExamScore;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarksRepo extends JpaRepository<MarksEntity,Integer> {
    @Query(nativeQuery = true, value = "select * from marks where course_id=course_id")
    List<MarksEntity> findStudentMarksByCourseID(@Param("course_id") String course_id);

    @Query(nativeQuery = true, value = "select * from marks where student_id=student_id")
    List<MarksEntity> getScoreByStudent_ID(@Param("student_id") String student_id);
}
