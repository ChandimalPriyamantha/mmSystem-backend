package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.VC;



import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.VC.GradeForVC;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;


public interface GradeForVCRepository extends JpaRepository<GradeForVC, Integer> {


//   Page<GradeForVC> findByCourseIdAndStudentId(@RequestParam("courseId") String courseId,@RequestParam("studentId") String studentId,Pageable pageable);

//
//
//    @Query("SELECT g, l FROM GradeForVC g INNER JOIN LevelForVC l ON g.courseId = l.courseId AND g.studentId = l.studentId WHERE g.courseId = :courseId AND g.studentId = :studentId")
//    Page<Object[]> findByCourseIdAndStudentIdWithInnerJoin(@Param("courseId") String courseId, @Param("studentId") String studentId, Pageable pageable);

    Page<GradeForVC> findGradeForVCByLevel(@RequestParam("level") String level, Pageable pageable);


}
