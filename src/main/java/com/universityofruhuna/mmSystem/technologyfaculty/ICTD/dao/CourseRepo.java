package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,String> {
    @Query(nativeQuery = true, value = "SELECT DISTINCT course.course_id , course.course_name , course.hours ,course.type ,course.credit ,course.department_id ,course.level ,course.semester from course inner join mark_approved_level on course.course_id =mark_approved_level.course_id  where course.department_id=?1 and course.level=?2 and course.semester=?3 and mark_approved_level.approval_level=?4 ORDER BY course_id")
    List<Course> findCoursesByDepartmentLevelSemester(String department_id ,int level, int semester,String approval_level);
}
