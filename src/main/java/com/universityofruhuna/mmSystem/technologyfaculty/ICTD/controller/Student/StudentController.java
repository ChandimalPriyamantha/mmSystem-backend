package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller.Student;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.GradeDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.MedicalDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.ResultBoardDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.EvaluationCriteriaDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.GPADTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentDetailsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.GPARepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Student.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/Student")
@AllArgsConstructor
@NoArgsConstructor
@Data


public class StudentController {
    @Autowired
    private StudentService studentService;

    /*---------------------------------------------------------------------------------------- Controller for students table ----------------------------START-------------*/

    @GetMapping("/getStudentDetailsByEmail/{email}")
    public StudentDetailsDTO getStudentDetailsByEmail(@PathVariable String email) {     // get student details by email
        return studentService.getStudentDetailsByEmail(email);

        /* Usage
            HomePageStudent
            StudentMedicalView
            StudentViewCourseDetails
            StudentViewEligibility
        */

    }




    /*---------------------------------------------------------------------------------------- Controller for students table ----------------------------END-------------*/





    

    /*---------------------------------------------------------------------------------------- Controller for medical table ----------------------------START-------------*/

    @GetMapping("/getStudentMedicalList/{student_id}")
    public List<MedicalDTO> getStudentMedicalList(@PathVariable String student_id) {        //Get list of all the medicals by selected student id
        return studentService.getStudentMedicalList(student_id);


        /* Usage
            StudentMedicalView
        */

    }


    @GetMapping("/getStudentMedicalListBySelectedYear/{student_id}/{academic_year}")
    public List<MedicalDTO> getStudentMedicalListBySelectedYear(@PathVariable String student_id, @PathVariable String academic_year){
        return studentService.getStudentMedicalListBySelectedYear(student_id,academic_year);


        /* Usage
            StudentMedicalView
        */


    }

    /*---------------------------------------------------------------------------------------- Controller for medical table ----------------------------END-------------*/


    /*---------------------------------------------------------------------------------------- Controller for course table ----------------------------START-------------*/

    @GetMapping("/getAllCourses")
    public List<CourseDTO> getAllCourses() {     //Get list of all the courses
        return studentService.getAllCourses();

        /* Usage
            StudentViewCourseDetails
        */
    }

    @GetMapping("/getCourseListByDepartment/{department_id}")
    public  List<CourseDTO> getCourseListByDepartment(@PathVariable String department_id) {     //Get list of all the courses by selected department id
        return studentService.getCourseListByDepartment(department_id);


        /* Usage
            StudentViewCourseDetails
        */
    }


    @GetMapping("/getStudentCourseListBySelectedYear/{student_id}/{academic_year}/{semester}")
    public  List<Object> getStudentCourseListBySelectedYear(@PathVariable String student_id, @PathVariable String academic_year, @PathVariable int semester) {     //Get list of all the courses by selected student id and selected academic year
        return studentService.getStudentCourseListBySelectedYear(student_id, academic_year, semester);

        /* Usage
            StudentViewEligibility
        */
    }


    @GetMapping("/getStudentLevelAndSemester/{student_id}")
    public CourseDTO getStudentLevelAndSemester(@PathVariable String student_id) {        //Get student current level and semester
        return studentService.getStudentLevelAndSemester(student_id);

        /* Usage
            StudentHomePage / PublishedMarksListPage
        */
    }


    /*---------------------------------------------------------------------------------------- Controller for course table ----------------------------END-------------*/







    /*---------------------------------------------------------------------------------------- Controller for Evaluation criteria table ----------------------------START-------------*/

    @GetMapping("/getEvaluationCriteriaByCourseId/{course_id}")
    public List<EvaluationCriteriaDTO> getEvaluationCriteriaByCourseId(@PathVariable String course_id) {     //Get list of all the evaluation criteria by selected course id
        return studentService.getEvaluationCriteriaByCourseId(course_id);

        /* Usage
            StudentViewCourseCriteria
        */
    }




    /*---------------------------------------------------------------------------------------- Controller for Evaluation criteria table ----------------------------END-------------*/





    /*---------------------------------------------------------------------------------------- Controller for Grade table ----------------------------START-------------*/


    @GetMapping("/getGradeBySelectedStudentSelectedGrade/{student_id}/{grade}")
    public List<GradeDTO> getGradeBySelectedStudentSelectedGrade(@PathVariable String student_id, @PathVariable String grade) {     //Get list of all the grades by selected student id and selected grade
        return studentService.getGradeBySelectedStudentSelectedGrade(student_id, grade);

        /* Usage
            StudentWithHeldSubjects
        */
    }

//    @GetMapping("/getSelectedStudentGrade/{level}/{semester}/{department_id}/{student_id}")
//    public List<GradeDTO> getSelectedStudentGrade(@PathVariable int level, @PathVariable int semester, @PathVariable String department_id, @PathVariable String student_id) {     //Get list of all the grades by selected student id
//        return studentService.getSelectedStudentGrade(level,semester,department_id,student_id);
//
//        /* Usage
//            HomePageStudent
//        */
//    }

    /*---------------------------------------------------------------------------------------- Controller for Grade table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Controller for result_board table ----------------------------START-------------*/

//    @GetMapping("/getPublishedMarkSheets/{approval_level}/{status}/{department_id}/{level}/{semester}")
//    public ResultBoardDTO getPublishedMarkSheets(@PathVariable String approval_level, @PathVariable String status, @PathVariable String department_id, @PathVariable String level, @PathVariable String semester) {      //Get  published marks sheet for student current level, semester and department
//        return studentService.getPublishedMarkSheets(approval_level, status,department_id,level,semester);
//
//        /* Usage
//            StudentHomePage
//        */
//    }


    @GetMapping("/getPublishedMarksSheetList/{approval_level}/{status}")            //Get published mark sheet list
    public List<ResultBoardDTO> getPublishedMarksSheetList(@PathVariable String approval_level, @PathVariable String status){
        return studentService.getPublishedMarksSheetList(approval_level, status);

        /*Usage
            HomePageStudent
        */
    }



    /*---------------------------------------------------------------------------------------- Controller for result_board table ----------------------------END-------------*/



    /*---------------------------------------------------------------------------------------- Controller for GPA table ----------------------------START-------------*/

    @GetMapping("/getLatestGPA/{student_id}")
    public GPADTO getLatestGPA(@PathVariable String student_id) {     //Get latest GPA by selected student id
        GPADTO gpa= studentService.getLatestGPA(student_id);
        System.out.println(gpa.getCgpa());
        return gpa;

        /* Usage
            StudentHomePage
        */
    }



    /*---------------------------------------------------------------------------------------- Controller for GPA table ----------------------------END-------------*/

}
