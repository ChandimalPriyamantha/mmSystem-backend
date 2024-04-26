package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.Year;

public interface ARGradeRepo extends JpaRepository<Grade,Integer> {

    //Update Final grade to With held details of selected student--------
    @Modifying
    @Query(nativeQuery = true, value = "update grade set grade='WH' where student_id=:student_id AND course_id=:course_id")
    void updateStudentFinalGrade(String student_id, String course_id);

}
