package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Student;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentMedicalRepo extends JpaRepository<Medical,Integer>{
    @Query(nativeQuery = true, value = "select * from medical where student_id=:student_id")        //Get list of all the medicals by selected student id
    List<Medical> getStudentMedicalList(String student_id);
}
