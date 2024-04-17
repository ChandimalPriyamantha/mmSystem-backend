package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AttendanceEligibility;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceEligibilityRepo extends JpaRepository<AttendanceEligibility,Integer>
{
    @Query(nativeQuery = true, value ="select * from attendance_eligibility where   course_id=:course_id and student_id=:student_id")
    AttendanceEligibility getAttendanceByStuIdCourseId(@Param("course_id") String course_id,@Param("student_id")String student_id);
}
