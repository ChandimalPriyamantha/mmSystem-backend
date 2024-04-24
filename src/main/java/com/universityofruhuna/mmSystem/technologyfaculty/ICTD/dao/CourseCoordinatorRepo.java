package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.CourseCoordinatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseCoordinatorRepo extends JpaRepository<CourseCoordinatorEntity,Integer> {

    @Query(nativeQuery = true, value = "select course_id from coursecoordinator where  user_id=: user_id")
    CourseCoordinatorEntity findCourseIDByUserID(@Param("user_id") String user_id);
}
