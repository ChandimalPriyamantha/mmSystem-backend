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

    public ResponseDTO saveLecturerDetails(LecturersRegDTO lecturerDetailObj){

        if(lecturerDetailObj==null)
        {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(null);
            responseDTO.setMessage("Empty");
        }
        else
        {
            LecturersRegEntity lecturersRegEntity = modelMapper.map(lecturerDetailObj ,LecturersRegEntity.class);


            try
            {
                lecturersRegRepo.save(lecturersRegEntity);
                responseDTO.setCode(VarList.RIP_SUCCESS);
                responseDTO.setContent(lecturersRegEntity);
                responseDTO.setMessage("Lecturer saved Successfully");
            }catch (Exception e)
            {
                responseDTO.setCode(VarList.RIP_ERROR);
                responseDTO.setContent(lecturersRegEntity);
                responseDTO.setMessage("Lecturer can not be saved ");
            }
        }
        return responseDTO;
    }


    public ResponseDTO getAllLecturers(){


        try
        {
            List<LecturersRegEntity> lecList = lecturersRegRepo.findAll();
            if(!lecList.isEmpty())
            {
                responseDTO.setCode(VarList.RIP_SUCCESS);
                responseDTO.setContent(modelMapper.map(lecList,new TypeToken<ArrayList<LecturersRegDTO>>(){}.getType()));
                responseDTO.setMessage("Data found");
            }
            else {
                responseDTO.setCode(VarList.RIP_ERROR);
                responseDTO.setContent(null);
                responseDTO.setMessage("No Data found");
            }

        }
        catch (Exception e)
        {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(null);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    public ResponseDTO editLecturerDetails(LecturersRegDTO lecturersRegDTO){
        if(lecturersRegRepo.existsById(lecturersRegDTO.getId()))
        {
            try {
                lecturersRegRepo.save(modelMapper.map(lecturersRegDTO,LecturersRegEntity.class));
                responseDTO.setCode(VarList.RIP_SUCCESS);
                responseDTO.setContent(null);
                responseDTO.setMessage("Updated Successfully");
            }catch (Exception e)
            {
                responseDTO.setCode(VarList.RIP_ERROR);
                responseDTO.setContent(lecturersRegDTO);
                responseDTO.setMessage("Can not update");
            }

        }
        return responseDTO;

    }

    public ResponseDTO deleteLecByID(int id)
    {
        if(lecturersRegRepo.existsById(id))
        {
            LecturersRegDTO lec=null;
            try
            {
                 lec=modelMapper.map(lecturersRegRepo.findById(id),LecturersRegDTO.class);
                lecturersRegRepo.deleteById(id);
                responseDTO.setCode(VarList.RIP_SUCCESS);
                responseDTO.setContent(lec);
                responseDTO.setMessage("Lecturer deleted Successfully");
            }catch (Exception e)
            {
                responseDTO.setCode(VarList.RIP_ERROR);
                responseDTO.setContent(lec);
                responseDTO.setMessage("Lecturer can not be deleted ");
            }

        }
        else {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(null);
            responseDTO.setMessage("Invalid lecturer id");
        }
        return responseDTO;
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
