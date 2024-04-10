package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.StudentCourseEnroll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;



public interface StudentCourseEnrollRepository extends JpaRepository<StudentCourseEnroll,Integer> {

    // to filter students the base on enrollment.
    Page<StudentCourseEnroll> findStudentByCourseId(@RequestParam("courseId") String courseId, Pageable pageable);

}
