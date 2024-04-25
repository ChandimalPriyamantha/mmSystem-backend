package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.MarksApprovalLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.annotation.Native;

public interface ApprovalLevelRepo extends JpaRepository<MarksApprovalLevel,Integer>
{

    @Modifying
    @Query(nativeQuery = true,value ="UPDATE mark_approved_level SET approval_level =:approval_level WHERE course_id=:course_id and academic_year=:academic_year")
    void updateApprovedLevel(@Param("course_id") String course_id, @Param("academic_year")String academic_year, @Param("approval_level") String approval_level);
}
