package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARGradeRepo extends JpaRepository<Grade,Integer> {

    //Get student id and other details from grade table where grade is E*
    @Query(nativeQuery = true, value="select * from grade inner join mark_approved_level on grade.course_id=mark_approved_level.course_id where grade.grade='E*' ")
    List<Grade>
}
