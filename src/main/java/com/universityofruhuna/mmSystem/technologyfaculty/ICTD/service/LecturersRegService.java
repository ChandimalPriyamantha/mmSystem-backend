package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.LecturersRegDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.LecturersRegRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.LecturersRegEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LecturersRegService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LecturersRegRepo lecturersRegRepo;

    public void saveLecturerDetails(LecturersRegDTO lecturerDetailObj){
        LecturersRegEntity lecturersRegEntity = modelMapper.map(lecturerDetailObj ,LecturersRegEntity.class);
        lecturersRegRepo.save(lecturersRegEntity);
    }


    public List<LecturersRegDTO> getAllLecturers(){
        List<LecturersRegEntity> lecList = lecturersRegRepo.findAll();
        return modelMapper.map(lecList,new TypeToken<ArrayList<LecturersRegDTO>>(){}.getType());
    }

    public void editLecturerDetails(LecturersRegDTO lecturersRegDTO){
        lecturersRegRepo.save(modelMapper.map(lecturersRegDTO,LecturersRegEntity.class));
    }

}
