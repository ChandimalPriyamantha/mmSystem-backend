package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,String> {
    @Query(nativeQuery = true, value = "SELECT * from course where department_id=?1 and level=?2 and semester=?3")
    List<Course> findCoursesByDepartmentLevelSemester(String department_id ,int level, int semester);
}
