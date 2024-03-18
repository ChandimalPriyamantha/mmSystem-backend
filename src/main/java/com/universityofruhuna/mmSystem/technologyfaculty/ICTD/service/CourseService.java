package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.CourseRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Course;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private ModelMapper mp;

    public List<CourseDTO> findCoursesByDepartmentLevelSemester(String department_id,int level, int semester){
        List<Course> courseList= courseRepo.findCoursesByDepartmentLevelSemester(department_id,level,semester);
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());
    }

    public List<CourseDTO> getAllCourses(){
        List<Course> courseList= courseRepo.findAll();
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());
    }
}
