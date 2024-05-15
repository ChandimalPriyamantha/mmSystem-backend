package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Marks_approved_log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface Approved_user_levelRepo extends JpaRepository<Marks_approved_log,Integer> {

    @Query(nativeQuery = true, value = "select * from marks_approved_log where course_id=:course_id and approved_user_level=:approved_level and academic_year=:academic_year")
    Marks_approved_log getSignature(@Param("course_id")String course_id,@Param("approved_level") String approved_level,@Param("academic_year") String academic_year);
}
