package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.LecturersRegDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.LecturersRegRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.CourseEntity;
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

    @Autowired
    ResponseDTO responseDTO;

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

    public ResponseDTO getAllLecId(){
        ArrayList<String> userIDlist = new ArrayList<>();
        List<LecturersRegEntity> list=lecturersRegRepo.findAll();
        if(!list.isEmpty())
        {
            for (LecturersRegEntity lecturersRegEntity : list) {
                userIDlist.add(lecturersRegEntity.getUser_id());
            }
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(userIDlist);
            responseDTO.setMessage("get all Lecturer IDs");

        }
        else
        {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setMessage("No data found");
            responseDTO.setContent(null);
        }

        return responseDTO;
    }

}
