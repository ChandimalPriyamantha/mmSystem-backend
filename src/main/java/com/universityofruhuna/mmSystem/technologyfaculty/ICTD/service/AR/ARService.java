package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.CourseRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.ArMarksRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Course;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ARService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private ArMarksRepo arMarksRepo;
    @Autowired
    private ModelMapper mp;

    public List<CourseDTO> findCoursesByDepartmentLevelSemester(String department_id,int level, int semester, String approval_level){
        List<Course> courseList= courseRepo.findCoursesByDepartmentLevelSemester(department_id,level,semester,approval_level);
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());

    }

    public List<CourseDTO> getAllCourses(){
        List<Course> courseList= courseRepo.findAll();
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());
    }

    /*Lakindu-Start--------------------*/
    public List<Object[]> findAllStudentMarksRemainingToApprove(String approval_level,String course_id ){


        return arMarksRepo.findAllStudentMarksRemainingToApprove(approval_level,course_id);

    }
}
