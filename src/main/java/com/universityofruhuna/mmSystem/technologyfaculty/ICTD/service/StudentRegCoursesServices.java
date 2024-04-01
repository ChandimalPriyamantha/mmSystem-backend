package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentRegCoursesDTO;
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

    public List<StudentRegCoursesDTO> getStudentsByCourseCode(String course_id)
    {
        List<StudentRegCourses> list=studentRegCoursesRepo.getStudentsbyCourseCode(course_id);
        return modelMapper.map(list,new TypeToken<ArrayList<StudentRegCoursesDTO>>(){}.getType());
    }
}
