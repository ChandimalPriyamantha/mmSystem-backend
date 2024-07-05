package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Student;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentStudentRepo extends JpaRepository<StudentDetailsEntity,Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM students WHERE email = :email LIMIT 1")
    StudentDetailsEntity getStudentDetailsByEmail(String email);              // get student details by email
}
