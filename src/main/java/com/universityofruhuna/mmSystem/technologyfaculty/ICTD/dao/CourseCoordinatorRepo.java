package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.CourseCoordinatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseCoordinatorRepo extends JpaRepository<CourseCoordinatorEntity,Integer>
{
    @Query(nativeQuery = true,value = "SELECT * FROM coursecoordinator where course_id =:course_id")
    public CourseCoordinatorEntity getCCBycourse(@Param("course_id")String course_id);

}
