package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CourseCoordinatorDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.CourseCoordinatorRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.CourseCoordinatorEntity;
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
public class CourseCoordinatorService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ResponseDTO responseDTO;
    @Autowired
    CourseCoordinatorRepo courseCoordinatorRepo;

    public ResponseDTO getAllCCs(){
        List<CourseCoordinatorEntity> courseCoordinatorEntities = courseCoordinatorRepo.findAll();
        if (courseCoordinatorEntities.isEmpty()){
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Course Coordinator not found!");
        }else {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(modelMapper.map(courseCoordinatorEntities, new TypeToken<ArrayList<CourseCoordinatorDTO>>(){}.getType()));
            responseDTO.setMessage("Course Coordinator found!");
        }
        return responseDTO;
    }

    public ResponseDTO insertCC(CourseCoordinatorDTO courseCoordinatorDTO){
        CourseCoordinatorEntity insertOneCC = modelMapper.map(courseCoordinatorDTO,CourseCoordinatorEntity.class);
        try {
            courseCoordinatorRepo.save(insertOneCC);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(courseCoordinatorDTO);
            responseDTO.setMessage("Course Coordinator has been inserted");
        }catch (Exception e){
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(courseCoordinatorDTO);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    public ResponseDTO getCCById(int id){
        if (courseCoordinatorRepo.existsById(id)){

            Optional<CourseCoordinatorEntity> CCById = courseCoordinatorRepo.findById(id);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(CCById);
            responseDTO.setMessage("Data found");

        }else {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Data not found");
        }

        return responseDTO;
    }

    public ResponseDTO updateCCById(CourseCoordinatorDTO courseCoordinatorDTO){
        CourseCoordinatorEntity updateOneCCById = modelMapper.map(courseCoordinatorDTO,CourseCoordinatorEntity.class);
        try {
            courseCoordinatorRepo.save(updateOneCCById);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(courseCoordinatorDTO);
            responseDTO.setMessage("Course Coordinator has been updated");
        }catch (Exception e){
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(courseCoordinatorDTO);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    public ResponseDTO deleteCCById(int id){
        if (courseCoordinatorRepo.existsById(id)){
            courseCoordinatorRepo.deleteById(id);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(id);
            responseDTO.setMessage("Course Coordinator has been deleted");
        }else {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(id);
            responseDTO.setMessage("Course Coordinator id not found");
        }
        return responseDTO;
    }


}
