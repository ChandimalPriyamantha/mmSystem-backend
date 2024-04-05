package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentDetailsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.StudentDetailsRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentDetailsEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentDetailsService {
    @Autowired
    private StudentDetailsRepo studentDetailsRepo;

    @Autowired
    private ModelMapper mmp;

    public void SaveStudentDetails(List <StudentDetailsDTO> studentDetailsList){
        studentDetailsRepo.saveAll(mmp.map( studentDetailsList,new TypeToken<ArrayList <StudentDetailsEntity>>(){}.getType()));

    }

}
