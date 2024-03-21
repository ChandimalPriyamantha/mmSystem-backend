package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.ARCourseRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.ArMarksRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Course;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.ARMarksEntity;
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
    private ARCourseRepo arCourseRepo;
    @Autowired
    private ArMarksRepo arMarksRepo;
    @Autowired
    private ModelMapper mp;

    public List<CourseDTO> findCoursesByDepartmentLevelSemester(String department_id,int level, int semester, String approval_level){
        List<Course> courseList= arCourseRepo.findCoursesByDepartmentLevelSemester(department_id,level,semester,approval_level);
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());

    }

    public List<CourseDTO> getAllCourses(){
        List<Course> courseList= arCourseRepo.findAll();
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());
    }

    public List<MarksDTO> findAllStudentMarksRemainingToApprove(String approval_level, String course_id ){

        List<ARMarksEntity> marksEntities=arMarksRepo.findAllStudentMarksRemainingToApprove(approval_level,course_id);
        return mp.map(marksEntities,new TypeToken<ArrayList<MarksDTO>>(){}.getType());

    }
}
