package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.ARMarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArMarksRepo extends JpaRepository<ARMarksEntity,Long> {

    @Query(nativeQuery = true, value = "select marks.id,marks.student_id,marks.course_id,marks.academic_year,marks.assignment_type,marks.assignment_score,marks.level,marks.semester from (marks left join grade on marks.course_id=grade.course_id and marks.student_id=grade.student_id)\n" +
            " left join mark_approved_level on  marks.course_id=mark_approved_level.course_id and marks.student_id=mark_approved_level.student_id\n" +
            " where mark_approved_level.approval_level=?1 and marks.course_id=?2 order by marks.student_id,marks.assignment_type")
    List<ARMarksEntity> findAllStudentMarksRemainingToApprove(String approval_level, String course_id);

    @Query(nativeQuery = true, value = "select marks.id,marks.student_id,marks.course_id,marks.academic_year,marks.assignment_type,marks.assignment_score,marks.level,marks.semester from (marks left join grade on marks.course_id=grade.course_id and marks.student_id=grade.student_id)\n" +
            " left join mark_approved_level on  marks.course_id=mark_approved_level.course_id and marks.student_id=mark_approved_level.student_id\n" +
            " where mark_approved_level.approval_level=?1 and marks.course_id=?2 and mark_approved_level.student_id=?3 order by marks.student_id,marks.assignment_type")
    List<ARMarksEntity> findAllStudentMarksRemainingToApproveByStuId(String approval_level, String course_id,String student_id);
}
