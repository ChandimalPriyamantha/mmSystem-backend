package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Student;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.GradeDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.MedicalDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.ResultBoardDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.EvaluationCriteriaDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.GPADTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentDetailsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.GPARepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Student.*;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Course;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Grade;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.ResultBoard;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.GPA;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentStudentRepo studentStudentRepo;
    @Autowired
    private StudentMedicalRepo studentMedicalRepo;
    @Autowired
    private StudentCourseRepo studentCourseRepo;
    @Autowired
    StudentEvaluationCriteriaRepo studentEvaluationCriteriaRepo;
    @Autowired
    StudentGradeRepo studentGradeRepo;
    @Autowired
    StudentResultBoardRepo studentResultBoardRepo;
    @Autowired
    StudentGPARepo studentGPARepo;

    @Autowired
    private ModelMapper mp;


    /*---------------------------------------------------------------------------------------- Service for students table ----------------------------START-------------*/

    public StudentDetailsDTO getStudentDetailsByEmail(String email) {     // get student details by email
        return mp.map(studentStudentRepo.getStudentDetailsByEmail(email), StudentDetailsDTO.class);
    }

    /*---------------------------------------------------------------------------------------- Service for students table ----------------------------END-------------*/





    /*---------------------------------------------------------------------------------------- Service for medical table ----------------------------START-------------*/

    public List<MedicalDTO> getStudentMedicalList(String student_id) {        //Get list of all the medicals by selected student id
        return mp.map(studentMedicalRepo.getStudentMedicalList(student_id), new TypeToken<ArrayList<MedicalDTO>>(){}.getType());
    }


    public List<MedicalDTO> getStudentMedicalListBySelectedYear(String student_id, String academic_year) {        //Get list of all the medicals by selected student id and selected academic year
        return mp.map(studentMedicalRepo.getStudentMedicalListBySelectedYear(student_id, academic_year), new TypeToken<ArrayList<MedicalDTO>>(){}.getType());
    }



    /*---------------------------------------------------------------------------------------- Service for medical table ----------------------------END-------------*/







    /*---------------------------------------------------------------------------------------- Service for course table ----------------------------START-------------*/

    public List<CourseDTO> getAllCourses() {     //Get list of all the courses
        return mp.map(studentCourseRepo.getAllCourses(), new TypeToken<ArrayList<CourseDTO>>(){}.getType());
    }

    public List<CourseDTO> getCourseListByDepartment(String department_id) {     //Get list of all the courses by selected department id
        return mp.map(studentCourseRepo.getCourseListByDepartment(department_id), new TypeToken<ArrayList<CourseDTO>>(){}.getType());
    }

    public List<Object> getStudentCourseListBySelectedYear(String student_id, String academic_year, int semester) {     //Get list of all the courses by selected student id and selected academic year and semester
        return studentCourseRepo.getStudentCourseListBySelectedYear(student_id, academic_year, semester);
    }


    public CourseDTO getStudentLevelAndSemester(String student_id) {        //Get student current level and semester
        return mp.map(studentCourseRepo.getStudentLevelAndSemester(student_id), CourseDTO.class);
    }


    public List<CourseDTO> getCourseDetailsForPublishedMarkSheet(int level, int semester, String department_id, String academic_year){      //Get all course details for mark sheet view by selected department, level, semester and academic year
        List<Course> courseList= studentCourseRepo.getCourseDetailsForPublishedMarkSheet(level, semester, department_id, academic_year);
        return mp.map(courseList,new TypeToken<ArrayList<CourseDTO>>(){}.getType());

    }



    /*---------------------------------------------------------------------------------------- Service for course table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Service for Evaluation criteria table ----------------------------START-------------*/

    public List<EvaluationCriteriaDTO> getEvaluationCriteriaByCourseId(String course_id) {     //Get list of all the evaluation criteria by selected course id
        return mp.map(studentEvaluationCriteriaRepo.getEvaluationCriteriaByCourseId(course_id), new TypeToken<ArrayList<EvaluationCriteriaDTO>>(){}.getType());
    }




    /*---------------------------------------------------------------------------------------- Service for Evaluation criteria table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Service for Grade table ----------------------------START-------------*/

    public List<GradeDTO> getGradeBySelectedStudentSelectedGrade(String student_id, String grade) {     //Get list of all the grades by selected student id and selected grade
        return mp.map(studentGradeRepo.getGradeBySelectedStudentSelectedGrade(student_id, grade), new TypeToken<ArrayList<GradeDTO>>(){}.getType());
    }


    public List<GradeDTO> getSelectedStudentGrade(int level, int semester, String department_id, String student_id) {     //Get list of all the grades by selected student id
        return mp.map(studentGradeRepo.getSelectedStudentGrade(level, semester, department_id, student_id), new TypeToken<ArrayList<GradeDTO>>(){}.getType());
    }


    public List<GradeDTO> getGradesForPublishedMarksSheet(int level, int semester, String department_id, String academic_year){          //Get list of all the grades by selected student id
        List<Grade> gradeList = studentGradeRepo.getGradesForPublishedMarksSheet(level, semester, department_id, academic_year);
        return mp.map(gradeList,new TypeToken<ArrayList<GradeDTO>>(){}.getType());

    }


    /*---------------------------------------------------------------------------------------- Service for Grade table ----------------------------END-------------*/




    /*---------------------------------------------------------------------------------------- Service for result_board table ----------------------------START-------------*/

    public ResultBoardDTO getPublishedMarkSheets(String approval_level, String status, String department_id, String level, String semester) {      //Get  published marks sheet for student current level, semester and department
        return mp.map(studentResultBoardRepo.getPublishedMarkSheets(approval_level, status,department_id,level,semester), ResultBoardDTO.class);
    }



    public List<ResultBoardDTO> getPublishedMarksSheetList(String approval_level, String status){          //Get published marks sheet list
        List<ResultBoard> resultBoardList = studentResultBoardRepo.getPublishedMarksSheetList(approval_level, status);
        return mp.map(resultBoardList,new TypeToken<ArrayList<ResultBoardDTO>>(){}.getType());
    }

    /*---------------------------------------------------------------------------------------- Service for result_board table ----------------------------END-------------*/





    /*---------------------------------------------------------------------------------------- Service for GPA table ----------------------------START-------------*/
    public GPADTO getLatestGPA(String student_id) {     //Get latest GPA by selected student id
        return mp.map(studentGPARepo.getLatestGPA(student_id), GPADTO.class);
    }


    public List<GPADTO> getGpaListForPublishedMarksSheet(String department_id, String academic_year, int level, int semester){        //Get list of all the GPAs for result board ar view
        List<GPA> gpaList= studentGPARepo.getGpaListForPublishedMarksSheet(department_id, academic_year, level, semester);
        return mp.map(gpaList,new TypeToken<ArrayList<GPADTO>>(){}.getType());
    }



    /*---------------------------------------------------------------------------------------- Service for GPA table ----------------------------END-------------*/


}
