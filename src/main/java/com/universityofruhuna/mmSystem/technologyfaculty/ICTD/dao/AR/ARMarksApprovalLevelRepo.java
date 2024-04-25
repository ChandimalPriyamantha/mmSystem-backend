package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.MarksApprovalLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARMarksApprovalLevelRepo extends JpaRepository<MarksApprovalLevel,Integer> {

    //This method is to find * details of mark approval level table with passing course id, student_id, approval level and approved year
    @Query(value = "select * from mark_approved_level where course_id=?1 and student_id=?2 and approval_level=?3 and approved_year=?4",nativeQuery = true)
    List<MarksApprovalLevel> getMarksApprovalLevelByAllParameters(String course_id, String student_id, String approval_level, String approved_year);


    //This method is to update mark approval level of mark approval_level_table with passing  new_approval_level, course_id,  student_id,  old_approval_level,  approved_year
    @Modifying
    @Query(value = "UPDATE mark_approved_level set approval_level=?1 where course_id=?2 and student_id=?3 and approval_level=?4 and approved_year=?5 ",nativeQuery = true)
    void updateMarksApprovalLevelByAllParameters(String new_approval_level,String course_id, String student_id, String old_approval_level, String approved_year);


}
