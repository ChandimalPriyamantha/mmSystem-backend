package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARGradeRepo extends JpaRepository<Grade,Integer> {

    //Get E* students records to list down 
    @Query(nativeQuery = true, value="select grade.student_id, course.course_id, course.course_name, course.level, course.semester, grade.grade, mark_approved_level.approval_level from ((grade inner join mark_approved_level on grade.course_id=mark_approved_level.course_id) inner join course on course.course_id=grade.course_id) where grade.grade='E*' order by course.level, course.semester, course.course_id ")
    List<Object[]> getEStarDetails();
}
