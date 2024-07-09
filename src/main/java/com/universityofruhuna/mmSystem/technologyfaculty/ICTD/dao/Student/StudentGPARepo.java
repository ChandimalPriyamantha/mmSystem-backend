package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Student;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.GPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentGPARepo extends JpaRepository<GPA,Integer> {

    @Query(nativeQuery = true, value = "select gpa.* from gpa where gpa.student_id = :student_id order by gpa.acadamic_year desc limit 1")
    GPA getLatestGPA(String student_id);     //Get latest GPA by selected student id

}
