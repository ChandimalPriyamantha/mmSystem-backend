package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArMarksRepo extends JpaRepository<MarksEntity,Integer> {

    @Query(nativeQuery = true, value = "select marks.id,marks.student_id,marks.course_id,marks.academic_year,marks.assignment_type,marks.assignment_score,marks.level,marks.semester from (marks left join grade on marks.course_id=grade.course_id and marks.student_id=grade.student_id)\n" +
            " left join mark_approved_level on  marks.course_id=mark_approved_level.course_id and marks.student_id=mark_approved_level.student_id\n" +
            " where mark_approved_level.approval_level=?1 and marks.course_id=?2 order by marks.student_id,marks.assignment_type")
    List<MarksEntity> findAllStudentMarksRemainingToApprove(String approval_level, String course_id);

    @Query(nativeQuery = true, value = "select marks.id,marks.student_id,marks.course_id,marks.academic_year,marks.assignment_type,marks.assignment_score,marks.level,marks.semester from (marks left join grade on marks.course_id=grade.course_id and marks.student_id=grade.student_id)\n" +
            " left join mark_approved_level on  marks.course_id=mark_approved_level.course_id and marks.student_id=mark_approved_level.student_id\n" +
            " where mark_approved_level.approval_level=?1 and marks.course_id=?2 and mark_approved_level.student_id=?3 order by marks.student_id,marks.assignment_type")
    List<MarksEntity> findAllStudentMarksRemainingToApproveByStuId(String approval_level, String course_id, String student_id);


    //Get E* students records to list down from marks table
    @Query(nativeQuery = true, value="select distinct course.level, course.semester, course.course_id, course.course_name, marks.student_id, marks.assignment_score, marks.assignment_name, mark_approved_level.approval_level from ((marks inner join mark_approved_level on marks.course_id=mark_approved_level.course_id) inner join course on course.course_id=marks.course_id) WHERE ((marks.assignment_score='E*')AND(marks.assignment_name='End theory exam' OR marks.assignment_name='End practical exam' OR marks.assignment_name='Mid theory exam' OR marks.assignment_name='Mid practical exam')) order by course.level, course.semester, course.course_id, marks.student_id")
    List<Object[]> getEStarDetails();

}
