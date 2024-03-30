package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepo extends JpaRepository<CourseEntity,String> {
    @Query(nativeQuery = true, value = "SELECT * FROM course where level=:level and semester= :sem")
    List<CourseEntity> FindCourseCodeAndNameByLS (@Param("level")int level,@Param("sem") int semester);
}
