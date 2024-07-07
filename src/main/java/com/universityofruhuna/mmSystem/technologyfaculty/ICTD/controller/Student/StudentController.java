package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller.Student;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.MedicalDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.EvaluationCriteriaDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentDetailsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Student.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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



}
