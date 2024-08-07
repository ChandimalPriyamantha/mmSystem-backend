package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentDetailsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.StudentDetailsRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentDetailsEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentDetailsService {
    @Autowired
    private StudentDetailsRepo studentDetailsRepo;

    @Autowired
    private ModelMapper mmp;

    @Autowired
    ResponseDTO responseDTO;

    public ResponseDTO getAllStudentsD(){
        List<StudentDetailsEntity> courseEntities = studentDetailsRepo.findAll();
        if (courseEntities.isEmpty()){
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Students Details not found!");
        }else {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(mmp.map(courseEntities, new TypeToken<ArrayList<StudentDetailsDTO>>(){}.getType()));
            responseDTO.setMessage("Students Details found!");
        }
        return responseDTO;
    }
    public ResponseDTO insertStudentDetailsAsBulk(List <StudentDetailsDTO> studentDetailsDTOS){

        if(studentDetailsDTOS.isEmpty())
        {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(studentDetailsDTOS);
            responseDTO.setMessage("Empty Data");
        }
        else {
            List<StudentDetailsEntity> studentDetailsAsBulk = mmp.map( studentDetailsDTOS,new TypeToken<ArrayList <StudentDetailsEntity>>(){}.getType());
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

            try {
                studentDetailsRepo.saveAll(studentDetailsAsBulk);
                responseDTO.setCode(VarList.RIP_SUCCESS);
                responseDTO.setContent(studentDetailsDTOS);
                responseDTO.setMessage("Students Details have been uploaded");
            }catch (Exception e){
                responseDTO.setCode(VarList.RIP_ERROR);
                responseDTO.setContent(studentDetailsDTOS);
                responseDTO.setMessage(e.getMessage());
            }
        }


        return responseDTO;
    }

    public ResponseDTO insertAStudentD(StudentDetailsDTO studentDetailsDTO){
        StudentDetailsEntity insertOneStudentD = mmp.map(studentDetailsDTO,StudentDetailsEntity.class);
        try {
            studentDetailsRepo.save(insertOneStudentD);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(studentDetailsDTO);
            responseDTO.setMessage("A Student Details has been inserted");
        }catch (Exception e){
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(studentDetailsDTO);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    public ResponseDTO getAStudentDById(int id){
        if (studentDetailsRepo.existsById(id)){

            Optional<StudentDetailsEntity> StudentDById = studentDetailsRepo.findById(id);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(StudentDById);
            responseDTO.setMessage("Data found");

        }else {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Data not found");
        }

        return responseDTO;
    }

    public ResponseDTO updateAStudentDById(StudentDetailsDTO studentDetailsDTO){
        if (studentDetailsRepo.existsById(studentDetailsDTO.getId())){
            try {
                studentDetailsRepo.save(mmp.map(studentDetailsDTO,StudentDetailsEntity.class));
                responseDTO.setCode(VarList.RIP_SUCCESS);
                responseDTO.setContent(studentDetailsDTO);
                responseDTO.setMessage("The Student Details has been updated");
            }catch (Exception e){
                responseDTO.setCode(VarList.RIP_ERROR);
                responseDTO.setContent(studentDetailsDTO);
                responseDTO.setMessage("can not update");
            }
        }


        return responseDTO;

    }

    public ResponseDTO deleteAStudentDById(int id){
        if (studentDetailsRepo.existsById(id)){
            studentDetailsRepo.deleteById(id);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(id);
            responseDTO.setMessage("The Student Details has been deleted");
        }else {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(id);
            responseDTO.setMessage("The Student Details id not found");
        }
        return responseDTO;
    }

}
