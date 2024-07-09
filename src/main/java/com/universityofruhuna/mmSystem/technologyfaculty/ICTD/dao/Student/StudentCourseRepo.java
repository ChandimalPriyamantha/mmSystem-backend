package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Student;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentCourseRepo extends JpaRepository<CourseEntity,Integer> {

    @Query(nativeQuery = true, value = "select course.* from course order by course.department_id asc, course.level asc, course.semester asc")
    List<CourseEntity> getAllCourses();     //Get list of all the courses

    @Query(nativeQuery = true, value="select course.* from course inner join courses_related_departments on course.course_id = courses_related_departments.course_id where courses_related_departments.department_id = :department_id order by course.level asc, course.semester asc")
    List<CourseEntity> getCourseListByDepartment(String department_id);     //Get list of all the courses by selected department id

    @Query (nativeQuery = true, value = " select course.*, grade.ca_eligibility from course inner join studentregcourses on course.course_id = studentregcourses.course_id LEFT JOIN grade on grade.student_id=studentregcourses.student_id and grade.course_id= studentregcourses.course_id where studentregcourses.student_id = :student_id and studentregcourses.academic_year = :academic_year and course.semester=:semester")
    List<Object> getStudentCourseListBySelectedYear(String student_id, String academic_year, int semester);     //Get list of all the courses by selected student id and selected academic year and semester



    @Query(nativeQuery = true, value = "select course.* from course inner join studentregcourses on course.course_id = studentregcourses.course_id where studentregcourses.student_id =:student_id order by course.level desc, course.semester desc limit 1")
    CourseEntity getStudentLevelAndSemester (String student_id);        //Get student current level and semester
}
