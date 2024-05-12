package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.List;

public interface CourseRepo extends JpaRepository<CourseEntity,Integer> {

    @Query(nativeQuery = true, value = "SELECT c.id, c.course_id,c.course_name,c.hours,c.type,c.credit,c.department_id,c.level,c.semester FROM course c inner join mark_approved_level on c.course_id=mark_approved_level.course_id where  c.department_id=:department and mark_approved_level.approval_level=:approved_level and c.level=:level and c.semester=:sem and academic_year=:academic_year" )
    List<CourseEntity> findApprovedCourses(@Param("level")int level, @Param("sem") int semester,@Param("department") String department,@Param("approved_level") String approved_level, @Param("academic_year") Year year);

}
