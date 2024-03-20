package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Course;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.ExamScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArMarksRepo extends JpaRepository<ExamScore,String> {
    @Query(nativeQuery = true, value = "select * from (marks left join grade on marks.course_id=grade.course_id and marks.student_id=grade.student_id)\n" +
            " left join mark_approved_level on  marks.course_id=mark_approved_level.course_id and marks.student_id=mark_approved_level.student_id\n" +
            " where mark_approved_level.approval_level=?1 and marks.course_id=?2")
    List<ExamScore> findAllStudentMarksRemainingToApprove(String approval_level, String course_id);
}
