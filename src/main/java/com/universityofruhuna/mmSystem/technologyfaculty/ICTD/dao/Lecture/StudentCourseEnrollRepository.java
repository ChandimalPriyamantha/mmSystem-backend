package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.StudentCourseEnroll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentCourseEnrollRepository extends JpaRepository<StudentCourseEnroll,Integer> {

    // to filter students' ID the base on enrollment with subjects.
    @Query("SELECT s FROM StudentCourseEnroll s WHERE s.courseId = :courseId AND " +
            "s.assignmentName = :assignmentName")
    Page<StudentCourseEnroll> findByCourseIdAndAssignmentName(String courseId,
                                                              String assignmentName,
                                                              Pageable pageable);
   // To filter students' details base on student ID & course ID & assignment name
    @Query("SELECT s FROM StudentCourseEnroll s WHERE s.courseId = :courseId AND " +
            "s.assignmentName = :assignmentName " +
            "AND s.studentId = :studentId")
    Page<StudentCourseEnroll> findStudentCourseEnrollByStudentIdAndAssignmentNameAndStudentId(String courseId,
                                                                                              String assignmentName,
                                                                                              String studentId,
                                                                                              Pageable pageable);

}
