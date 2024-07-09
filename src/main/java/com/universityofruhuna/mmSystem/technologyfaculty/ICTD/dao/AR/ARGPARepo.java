package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.GPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARGPARepo extends JpaRepository<GPA,Integer> {

    @Query(nativeQuery = true, value = "select gpa.* from gpa inner join students on students.student_id = gpa.student_id where students.department_id=:department_id AND gpa.acadamic_year=:academic_year AND gpa.level=:level and gpa.semester=:semester")
    List<GPA> getGpaListForResultBoard(String department_id, String academic_year, int level, int semester);        //Get list of all the GPAs for result board ar view
}