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


/* Lakindu-Start---------------------------*/
    @Query(nativeQuery = true, value = "select * from (marks left join grade on marks.course_id=grade.course_id and marks.student_id=grade.student_id)\n" +
            " left join mark_approved_level on  marks.course_id=mark_approved_level.course_id and marks.student_id=mark_approved_level.student_id\n" +
            " where mark_approved_level.approval_level=?1 and marks.course_id=?2")
    List<Object[]> findAllStudentMarksRemainingToApprove( String approval_level,String course_id);

    @Query(nativeQuery = true, value = "select * from grade  where grade.student_id= :id")
    List<StudentMarks> findCoursecodeOverallScoreByStId(@Param("id") String id);


}
