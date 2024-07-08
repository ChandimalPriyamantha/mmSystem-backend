package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Student;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentGradeRepo extends JpaRepository<Grade,Integer> {

    @Query(nativeQuery = true, value = "select grade.* from grade where grade.student_id = :student_id and grade.grade = :grade")
    List<Grade> getGradeBySelectedStudentSelectedGrade(String student_id, String grade);     //Get list of all the grades by selected student id and selected grade

    @Query(nativeQuery = true, value="select grade.* from grade where grade.student_id = :student_id")
    List<Grade> getSelectedStudentGrade(String student_id);     //Get list of all the grades by selected student id
}
