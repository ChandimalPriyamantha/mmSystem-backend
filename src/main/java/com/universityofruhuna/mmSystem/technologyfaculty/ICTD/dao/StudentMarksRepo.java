package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

public interface StudentMarksRepo extends JpaRepository<StudentMarks,Integer> {

    @Query(nativeQuery = true, value = "select * from grade g where g.level = :level and g.semester = :semester")
    List<StudentMarks> findStudentMarksByLevelSemester(@Param("level") String level, @Param("semester") String semester);

}
