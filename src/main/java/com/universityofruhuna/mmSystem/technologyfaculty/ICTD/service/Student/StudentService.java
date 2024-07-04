package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Student;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.MedicalDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentDetailsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Student.StudentMedicalRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Student.StudentRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentMedicalRepo studentMedicalRepo;

    @Autowired
    private ModelMapper mp;


    /*---------------------------------------------------------------------------------------- Service for students table ----------------------------START-------------*/

    public StudentDetailsDTO getStudentDetailsByEmail(String email) {     // get student details by email
        return mp.map(studentRepo.getStudentDetailsByEmail(email), StudentDetailsDTO.class);
    }

    /*---------------------------------------------------------------------------------------- Service for students table ----------------------------END-------------*/




    /*---------------------------------------------------------------------------------------- Service for medical table ----------------------------START-------------*/

    public List<MedicalDTO> getStudentMedicalList(String student_id) {        //Get list of all the medicals by selected student id
        return mp.map(studentMedicalRepo.getStudentMedicalList(student_id), new TypeToken<ArrayList<MedicalDTO>>(){}.getType());
    }

    /*---------------------------------------------------------------------------------------- Service for medical table ----------------------------END-------------*/




}
