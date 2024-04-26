package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.MarksApprovalLevelDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.MedicalDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.UpdateEStarDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.*;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Course;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.MarksApprovalLevel;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Medical;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.MarksEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
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
    private ARMedicalRepo arMedicalRepo;
    @Autowired
    private ModelMapper mp;


    //-----------------Services for course table---------------------------------------START

    public List<CourseDTO> findCoursesByDepartmentLevelSemester(String department_id,int level, int semester, String approval_level){
        List<Course> courseList= arCourseRepo.findCoursesByDepartmentLevelSemester(department_id,level,semester,approval_level);
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());

    }

    public List<CourseDTO> getAllCourses(){
        List<Course> courseList= arCourseRepo.findAll();
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());
    }

    //-----------------Services for course table---------------------------------------END

    //-----------------Services for marks table---------------------------------------START

    public List<MarksDTO> findAllStudentMarksRemainingToApprove(String approval_level, String course_id ){

        List<MarksEntity> marksEntities=arMarksRepo.findAllStudentMarksRemainingToApprove(approval_level,course_id);
        return mp.map(marksEntities,new TypeToken<ArrayList<MarksDTO>>(){}.getType());

    }

    public List<MarksDTO> findAllStudentMarksRemainingToApproveByStuId(String approval_level, String course_id,String student_id ){

        List<MarksEntity> marksEntities=arMarksRepo.findAllStudentMarksRemainingToApproveByStuId(approval_level,course_id,student_id);
        return mp.map(marksEntities,new TypeToken<ArrayList<MarksDTO>>(){}.getType());
    }

    //-----------------Services for marks table---------------------------------------END





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



    /* ----------------------------------------------------------------------New Update Start -------------------------------------------------------------------------------------------------------------------------------------------------------*/


    /*---------------------------------------------------------------------------------------- Service for medical table ----------------------------START-------------*/
    //This method get all medical submission list related to a particular year
    public List<MedicalDTO> getAllMedicalSubmissions(String academic_year){
        List<Medical> allMedicalList = arMedicalRepo.getAllMedicalSubmissions(academic_year);
        return  mp.map(allMedicalList,new TypeToken<ArrayList<MedicalDTO>>(){}.getType());
    }

    //Get medical details of selected one student for a selected exam
    public List<MedicalDTO> getSelectedStudentMedicalDetails(String student_id, String course_id, String academic_year, String exam_type){
        List<Medical> selectedStudentMedicalDetails = arMedicalRepo.getSelectedStudentMedicalDetails(student_id,course_id,academic_year,exam_type);
        return mp.map(selectedStudentMedicalDetails,new TypeToken<ArrayList<MedicalDTO>>(){}.getType());
    }

    /*---------------------------------------------------------------------------------------- Service for medical table ----------------------------END-------------*/

    //Get student id and other details from marks table where grade is E*........
    public List<Object[]> getEStarDetails(){
        List<Object[]> eStarList= arMarksRepo.getEStarDetails();
        return eStarList;
    }

    /*---------------------------------------------------------------------------------------- Service for marks table ----------------------------START-------------*/

    public int updateStudentGrade(UpdateEStarDTO updateEStarDTO){      //Update selected student grade with medical submissions

        return arMarksRepo.updateStudentGrade(updateEStarDTO.getNew_grade(),updateEStarDTO.getStudent_id(),updateEStarDTO.getCourse_id(), Year.parse(updateEStarDTO.getAcademic_year()),updateEStarDTO.getExam_type());

    }


    /*---------------------------------------------------------------------------------------- Service for marks table ----------------------------END-------------*/

    /*---------------------------------------------------------------------------------------- Service for grade table ----------------------------START-------------*/
    public void updateStudentFinalGrade(UpdateEStarDTO updateEStarDTO){         //Update selected student's Final grade to WH
        arGradeRepo.updateStudentFinalGrade(updateEStarDTO.getStudent_id(),updateEStarDTO.getCourse_id());
    }
    /*---------------------------------------------------------------------------------------- Service for grade table ----------------------------END-------------*/


    /*---------------------------------------------------------------------------------------- Service for course table ----------------------------START-------------*/
    public List<CourseDTO> getViewMarksCourseList(String level, String semester,String department_id){
        List<Course> courseList= arCourseRepo.getViewMarksCourseList(level, semester, department_id);
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());
    }
    /*---------------------------------------------------------------------------------------- Service for course table ----------------------------END-------------*/

}

