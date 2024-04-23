package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.GradeDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.MarksApprovalLevelDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.ARCourseRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.ARGradeRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.ARMarksApprovalLevelRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.ArMarksRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Course;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Grade;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.MarksApprovalLevel;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.MarksEntity;
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
    private ARMarksApprovalLevelRepo arMarksApprovalLevelRepo;
    @Autowired
    private ARGradeRepo arGradeRepo;
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

        List<MarksEntity> marksEntities=arMarksRepo.findAllStudentMarksRemainingToApprove(approval_level,course_id);
        return mp.map(marksEntities,new TypeToken<ArrayList<MarksDTO>>(){}.getType());

    }

    public List<MarksDTO> findAllStudentMarksRemainingToApproveByStuId(String approval_level, String course_id,String student_id ){

        List<MarksEntity> marksEntities=arMarksRepo.findAllStudentMarksRemainingToApproveByStuId(approval_level,course_id,student_id);
        return mp.map(marksEntities,new TypeToken<ArrayList<MarksDTO>>(){}.getType());

    }

    //This method is to find * details of mark approval level table with passing course id, student_id, approval level and approved year
    public List<MarksApprovalLevelDTO> getMarksApprovalLevelByAllParameters(String course_id,String student_id,String approval_level, String approved_year){

        List<MarksApprovalLevel> marksApprovalLevelList=arMarksApprovalLevelRepo.getMarksApprovalLevelByAllParameters(course_id,student_id,approval_level,approved_year);
        return  mp.map(marksApprovalLevelList,new TypeToken<ArrayList<MarksApprovalLevelDTO>>(){}.getType());

    }

    //This method is to update mark approval level of mark approval_level_table with passing  new_approval_level, course_id,  student_id,  old_approval_level,  approved_year

    public Boolean updateMarksApprovalLevelByAllParameters(String new_approval_level,String course_id, String student_id, String old_approval_level, String approved_year){
        List <MarksApprovalLevel> marksApprovalLevelList =arMarksApprovalLevelRepo.getMarksApprovalLevelByAllParameters(course_id,student_id,old_approval_level,approved_year);
        if(marksApprovalLevelList.isEmpty()){
            return false;
        }else
            arMarksApprovalLevelRepo.updateMarksApprovalLevelByAllParameters( new_approval_level, course_id,  student_id,  old_approval_level,  approved_year);
        return true;
    }

    //Get student id and other details from marks table where grade is E*........
    public List<Object[]> getEStarDetails(){
        List<Object[]> eStarList= arMarksRepo.getEStarDetails();
        return eStarList;
    }
}
