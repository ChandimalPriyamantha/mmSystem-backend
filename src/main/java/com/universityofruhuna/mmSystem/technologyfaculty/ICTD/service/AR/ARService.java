package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.*;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR.*;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.*;
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
    @Autowired ARAcademicYearDetailsRepo arAcademicYearDetailsRepo;
    @Autowired
    private ModelMapper mp;


    /* ----------------------------------------------------------------------New Update Start -------------------------------------------------------------------------------------------------------------------------------------------------------*/


    /*---------------------------------------------------------------------------------------- Service for medical table ----------------------------START-------------*/

    public List<MedicalDTO> getAllMedicalSubmissionsByYear(String academic_year){     //This method get all medical submission list related to a particular year
        List<Medical> allMedicalList = arMedicalRepo.getAllMedicalSubmissionsByYear(academic_year);
        return  mp.map(allMedicalList,new TypeToken<ArrayList<MedicalDTO>>(){}.getType());
    }

    public List<MedicalDTO> getAllMedicalSubmissions(){     //This method get all medical submission list
        List<Medical> allMedicalList = arMedicalRepo.getAllMedicalSubmissions();
        return  mp.map(allMedicalList,new TypeToken<ArrayList<MedicalDTO>>(){}.getType());
    }

    //Get medical details of selected one student for a selected exam
    public List<MedicalDTO> getSelectedStudentMedicalDetails(String student_id, String course_id, String academic_year, String exam_type){
        List<Medical> selectedStudentMedicalDetails = arMedicalRepo.getSelectedStudentMedicalDetails(student_id,course_id,academic_year,exam_type);
        return mp.map(selectedStudentMedicalDetails,new TypeToken<ArrayList<MedicalDTO>>(){}.getType());
    }

    /*---------------------------------------------------------------------------------------- Service for medical table ----------------------------END-------------*/







    /*---------------------------------------------------------------------------------------- Service for marks table ----------------------------START-------------*/


    //Get all from marks table by providing student id , course id, academic year, and exam type
    public List<MarksDTO> getSelectedStudentSelectedExamMarksBySelectedCourseAndSelectedAcademicYear(String student_id, String course_id, String academic_year , String exam_type){
        List<MarksEntity> marksList = arMarksRepo.getSelectedStudentSelectedExamMarksBySelectedCourseAndSelectedAcademicYear(student_id, course_id, academic_year, exam_type);
        return mp.map(marksList,new TypeToken<ArrayList<MarksDTO>>(){}.getType());
    }
    public int updateStudentScore(UpdateABDTO updateABDTO){      //Update selected student grade with medical submissions

        return arMarksRepo.updateStudentScore(updateABDTO.getNew_score(), updateABDTO.getStudent_id(), updateABDTO.getCourse_id(), updateABDTO.getAcademic_year(), updateABDTO.getExam_type());

    }


    /*---------------------------------------------------------------------------------------- Service for marks table ----------------------------END-------------*/








    /*---------------------------------------------------------------------------------------- Service for grade table ----------------------------START-------------*/
    public void updateStudentFinalGrade(GradeDTO gradeDTO){         //Update selected student's Final grade

        if(arGradeRepo.existsById(gradeDTO.getId())) {
            arGradeRepo.save(mp.map(gradeDTO, Grade.class));
        }


    }

    public List<GradeDTO> findAllStudentMarksGrade(String course_id){          //Get all student grades of selected course module
        List<Grade> gradeList = arGradeRepo.findAllStudentGrade(course_id);
        return mp.map(gradeList,new TypeToken<ArrayList<GradeDTO>>(){}.getType());

    }

    public List<GradeDTO> findSelectedStudentMarksGrade(String course_id, String student_id){          //Get selected student grades of selected course module
        List<Grade> gradeList = arGradeRepo.findSelectedStudentGrade(course_id,student_id);
        return mp.map(gradeList,new TypeToken<ArrayList<GradeDTO>>(){}.getType());

    }
    /*---------------------------------------------------------------------------------------- Service for grade table ----------------------------END-------------*/











    /*---------------------------------------------------------------------------------------- Service for course table ----------------------------START-------------*/
    public List<CourseDTO> getViewMarksCourseList(String level, String semester,String department_id){      //Get all course details of selected department by level and semester
        List<Course> courseList= arCourseRepo.getViewMarksCourseList(level, semester, department_id);
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());
    }
    /*---------------------------------------------------------------------------------------- Service for course table ----------------------------END-------------*/









    /*---------------------------------------------------------------------------------------- Service for approve level table ----------------------------START-------------*/

    public List<MarksApprovalLevelDTO> getNotApprovedCoursesByLevelSemester(String level,String semester, String approval_level, String academic_year){         //Get * from marks Approval level table by selected level, semester, academic year and where approval level is not equal to provided level


        List<MarksApprovalLevel> notApprovedList=arMarksApprovalLevelRepo.getNotApprovedCoursesByLevelSemester( level,semester, approval_level, academic_year);
        return  mp.map(notApprovedList,new TypeToken<ArrayList<MarksApprovalLevelDTO>>(){}.getType());

    }

    public List<MarksApprovalLevelDTO> getMarksApprovalLevelBySelectedCourseAndAcademicYear(String course_id, String academic_year ){           //Get * from marks Approval level table by selected level, semester, academic year and where approval level is not equal to provided level
        List<MarksApprovalLevel> list = arMarksApprovalLevelRepo.getMarksApprovalLevelBySelectedCourseAndAcademicYear(course_id,academic_year);
        return mp.map(list,new TypeToken<ArrayList<MarksApprovalLevelDTO>>(){}.getType());
    }

    /*---------------------------------------------------------------------------------------- Service for approve level table ----------------------------END-------------*/













    /*---------------------------------------------------------------------------------------- Service for academic_year_details table ----------------------------START-------------*/
    public List<AcademicYearDetailsDTO> getAcademicYearDetails(){
        List<AcademicYearDetails> academicYearDetails= arAcademicYearDetailsRepo.findAll();
        return mp.map(academicYearDetails, new TypeToken<ArrayList<AcademicYearDetailsDTO>>(){}.getType());
    }


    /*---------------------------------------------------------------------------------------- Service for academic_year_details table ----------------------------END-------------*/




    public List<Object[]> getABDetails(){        //Get all  students records to list down from marks table having AB s for valid exams
        List<Object[]> eStarList= arMarksRepo.getABDetails();
        return eStarList;
    }

    public List<Object[]> getABDetailsByCourseId(String course_id){        //Get student id and other details from marks table where grade is E* by selected course........
        List<Object[]> abList= arMarksRepo.getABDetailsByCourseId(course_id);
        return abList;
    }
}

