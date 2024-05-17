package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.MarksApprovalLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARMarksApprovalLevelRepo extends JpaRepository<MarksApprovalLevel,Integer> {




    //Get * from marks Approval level table by selected level, semester, academic year and where approval level is not equal to provided level
    @Query(nativeQuery = true, value="select mark_approved_level.* from mark_approved_level inner join course on mark_approved_level.course_id=course.course_id where" +
            " course.level=:level AND course.semester=:semester AND mark_approved_level.approval_level!=:approval_level AND mark_approved_level.academic_year=:academic_year")
    List<MarksApprovalLevel> getNotApprovedCoursesByLevelSemester(String level,String semester, String approval_level, String academic_year);

    //This method is to find * details of mark approval level table with passing course id and academic year
    @Query(value = "select * from mark_approved_level where course_id=:course_id and academic_year=:academic_year ",nativeQuery = true)
    List<MarksApprovalLevel> getMarksApprovalLevelBySelectedCourseAndAcademicYear(String course_id, String academic_year );
}
