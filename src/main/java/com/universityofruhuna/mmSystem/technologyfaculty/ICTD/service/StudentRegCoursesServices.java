package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentRegCoursesDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.StudentRegCoursesRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentRegCourses;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentRegCoursesServices
{
    @Autowired
    private StudentRegCoursesRepo studentRegCoursesRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseDTO getStudentsByCourseCode(String course_id)
    {
        List<StudentRegCourses> list=studentRegCoursesRepo.getStudentsbyCourseCode(course_id);

        ResponseDTO responseDTO=new ResponseDTO();

        List<StudentRegCoursesDTO> list1=modelMapper.map(list,new TypeToken<ArrayList<StudentRegCoursesDTO>>(){}.getType());

        if(list.isEmpty())
        {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("No data found");
        }
        else
        {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(list1);
            responseDTO.setMessage("Successfull");


        }
        return responseDTO;
    }
}
