package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.MarksRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.MarksEntity;
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
public class MarksService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MarksRepo marksRepo;
    public List<MarksDTO> getAllScore(){

        List<MarksEntity> markList=marksRepo.findAll();
        return modelMapper.map(markList,new TypeToken<ArrayList<MarksDTO>>(){}.getType());
    }


    public List<MarksDTO> getAllScoreByCourseId(String course_id){

        List<MarksEntity> list=marksRepo.findStudentMarksByCourseID(course_id);

        return modelMapper.map(list,new TypeToken<ArrayList<MarksDTO>>(){}.getType());
    }

    public void editScore(MarksDTO marksDTO)
    {
        marksRepo.save(modelMapper.map(marksDTO,MarksEntity.class));
    }

    public Optional<MarksEntity> getScoreByID(int id)
    {
        return marksRepo.findById(id);
    }



    public List<MarksDTO> getScoreByStudent_ID(String student_id)
    {
        List<MarksEntity> list=marksRepo.getScoreByStudent_ID(student_id);
        return modelMapper.map(list,new TypeToken<ArrayList<MarksDTO>>(){}.getType());
    }


    public List<MarksDTO> getScoreByStuIDCourseID(String course_id,String student_id)
    {
        List<MarksEntity> list=marksRepo.getScoreByStuIDCourseID(course_id,student_id);
        return modelMapper.map(list,new TypeToken<ArrayList<MarksDTO>>(){}.getType());
    }

    public List<MarksDTO> getScoreByLS(String level,String  semester)
    {
        List<MarksEntity> list=marksRepo.getScoreByLS(level,semester);
        return modelMapper.map(list,new TypeToken<ArrayList<MarksDTO>>(){}.getType());
    }



}
