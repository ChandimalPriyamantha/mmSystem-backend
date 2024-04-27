package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

public interface StudentMarksRepo extends JpaRepository<StudentMarks,Integer> {

    @Query(nativeQuery = true, value = "select * from grade g where g.level = :level and g.semester = :semester")
    List<StudentMarks> findStudentMarksByLevelSemester(@Param("level") String level, @Param("semester") String semester);

    @Query(nativeQuery = true, value = "SELECT grade.id,grade.student_id,grade.course_id,grade.level,grade.semester,grade.overall_score,grade.grade FROM scoredb.grade  inner join course on grade.course_id=course.course_id inner join mark_approved_level on course.course_id=mark_approved_level.course_id where course.level=:level and course.semester=:semester and mark_approved_level.approval_level=:approved_level")
    List<StudentMarks> findStudentMarksByLS(@Param("level") String level, @Param("semester") String semester,@Param("approved_level")String approved_level);


    @Query(nativeQuery = true, value = "select * from grade  where grade.student_id= :id")
    List<StudentMarks> findCoursecodeOverallScoreByStId(@Param("id") String id);

    @Query(nativeQuery = true, value = "select * from grade where   course_id=:course_id")
    List<StudentMarks> findMarksByCourse(@Param("course_id") String course_id);

    @Query(nativeQuery = true, value = "select * from grade where   course_id=:course_id and student_id=:student_id")
    StudentMarks findMarksByCS(@Param("course_id") String course_id,@Param("student_id")String student_id);

}
