package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARMedicalRepo extends JpaRepository<Medical,Integer> {

    @Query(nativeQuery = true, value = "select * from medical where academic_year=?1")
    List<Medical> getAllMedicalSubmissions(String academic_year);

}
