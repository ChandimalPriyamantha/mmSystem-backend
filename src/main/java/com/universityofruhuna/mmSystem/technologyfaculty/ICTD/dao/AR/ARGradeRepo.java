package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.Year;
import java.util.List;

public interface ARGradeRepo extends JpaRepository<Grade,Integer> {


    @Modifying
    @Query(nativeQuery = true, value = "update grade set grade=:grade where student_id=:student_id AND course_id=:course_id")     //Update Final grade to With held details of selected student
    void updateStudentFinalGrade(String grade,String student_id, String course_id);

    @Query(nativeQuery = true, value = "select grade.* from grade" +     //Get all student grades of selected course module
            " where grade.course_id=:course_id ")
    List<Grade> findAllStudentGrade (String course_id);

    @Query(nativeQuery = true, value = "select grade.* from grade" +     //Get selected student grades of selected course module
            " where grade.course_id=:course_id AND grade.student_id=:student_id")
    List<Grade> findSelectedStudentGrade (String course_id, String student_id);

}
