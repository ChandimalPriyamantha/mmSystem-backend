package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARCourseRepo extends JpaRepository<Course,String> {

    /* Find all courses and its details passing department id, level, semester and mark approval level from course table those are pending for AR approval. */
    @Query(nativeQuery = true, value = "SELECT DISTINCT course.course_id , course.course_name , course.hours ,course.type ,course.credit ,course.department_id ,course.level ,course.semester " +
            "from course inner join mark_approved_level on course.course_id =mark_approved_level.course_id  where course.department_id=?1 and course.level=?2 and course.semester=?3 and mark_approved_level.approval_level=?4 ORDER BY course_id")
    List<Course> findCoursesByDepartmentLevelSemester(String department_id ,int level, int semester,String approval_level);

    @Query(nativeQuery = true, value = "select * from (marks left join grade on marks.course_id=grade.course_id and marks.student_id=grade.student_id)\n" +
            " left join mark_approved_level on  marks.course_id=mark_approved_level.course_id and marks.student_id=mark_approved_level.student_id\n" +
            " where mark_approved_level.approval_level=?1 and marks.course_id=?2")
    List<Object[]> findAllStudentMarksRemainingToApprove(String approval_level, String course_id);

    //Find all course details from the course table passing approved level and grade.....................
    @Query(nativeQuery = true,value = "select  DISTINCT course.course_id , course.course_name , course.hours ,course.type ,course.credit ,course.department_id ,course.level ,course.semester" +
            "from course inner join mark_approved_level on course.course_id =mark_approved_level.course_id and course.course_id=grade.course+id" +
            "where mark_approved_level.approval_level=?1 and grade.grade=?2")
    List<Course> findCoursesByApprovalLevelAndGrade(String approval_level, String grade);
}
