package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.GPA;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GPARepo extends JpaRepository<GPA,Integer>
{
    @Query(nativeQuery = true, value = "select * from gpa  where student_id= :id")
    GPA findGPAByStId(@Param("id") String id);
}
