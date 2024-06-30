package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query(nativeQuery = true,value = "select * from students where student_id=:student_id")
    Student getStudentDetailsByStudentID(@Param("student_id") String student_id);
}
