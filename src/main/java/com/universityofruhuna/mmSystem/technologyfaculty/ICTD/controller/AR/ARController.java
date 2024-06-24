package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.*;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.AcademicYearDetails;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Grade;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AR.ARService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/AssistantRegistrar")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ARController {
    @Autowired
    private ARService arService;
    @Autowired
    private ResponseDTO responseDTO;


    /*---------------------------------------------------------------------------------------- Controller for course table ----------------------------START-------------*/
    @GetMapping("/getViewMarksCourseList/{level}/{semester}/{department_id}")           //Get all course details of selected department by level and semester
    public List<CourseDTO> getViewMarksCourseList (@PathVariable String level, @PathVariable String semester, @PathVariable String department_id){

        return arService.getViewMarksCourseList(level, semester,department_id);


        /*Usage
            CourseSelection
         */
    }

    @GetMapping("/GetAllCoursesBySelectedDepartmentLevelSemester/{department_id}/{level}/{semester}/{academic_year}")
    public List<CourseDTO> GetAllCoursesBySelectedDepartmentLevelSemester(@PathVariable String department_id, @PathVariable String level, @PathVariable String semester, @PathVariable String academic_year){
        return arService.GetAllCoursesBySelectedDepartmentLevelSemester(department_id,level,semester,academic_year);
    }

    /*---------------------------------------------------------------------------------------- Controller for course table ----------------------------END-------------*/





    /*---------------------------------------------------------------------------------------- Controller for medical table ----------------------------START------------*/
    @GetMapping("/getAllMedicalSubmissionsByYear/{academic_year}")    //controller to get all medical list by selected academic year
    public List<MedicalDTO> getAllMedicalSubmissionsByYear(@PathVariable String academic_year){
        return arService.getAllMedicalSubmissionsByYear(academic_year);


        /*Usage
            UpdateABPage
            ViewMedicalPage
         */
    }

    @GetMapping("/getAllMedicalSubmissions")    //controller to get all medical list by selected academic year
    public List<MedicalDTO> getAllMedicalSubmissions(){
        return arService.getAllMedicalSubmissions();



        /*Usage
            ViewMedicalPage
         */
    }

    @GetMapping("/getSelectedStudentMedicalDetails/{student_id}/{course_id}/{academic_year}/{exam_type}")   //Controller to get selected student's medical details for selected exam
    public List<MedicalDTO> getSelectedStudentMedicalDetails(@PathVariable String student_id, @PathVariable String course_id, @PathVariable String academic_year, @PathVariable String exam_type){
        return arService.getSelectedStudentMedicalDetails(student_id, course_id, academic_year, exam_type);


        /*Usage
            UpdateABPage
         */
    }


    /*---------------------------------------------------------------------------------------- Controller for medical table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Controller for marks table ----------------------------START-------------*/


    @GetMapping("/getABDetails")      //Get all  students records to list down from marks table having AB s for valid exams
    public List<Object[]> getABDetails(){
        return arService.getABDetails();


        /*Usage
        ABListPage

         */
    }

    @GetMapping("/getABDetailsByCourseId/{course_id}")      //Get student id and other details from marks table where grade is E*        This is for view marks table to identify is there E* for the subject
    public List<Object[]> getABDetailsByCourseId(@PathVariable String course_id){
        return arService.getABDetailsByCourseId(course_id);

        /*Usage
            ViewMarksTable
            ViewMarksTableValidations
         */
    }

    @GetMapping("/getSelectedStudentSelectedExamMarksBySelectedCourseAndSelectedAcademicYear/{student_id}/{course_id}/{academic_year}/{exam_type}")                 //Get all from marks table by providing student id , course id, academic year, and exam type
    public List<MarksDTO> getSelectedStudentSelectedExamMarksBySelectedCourseAndSelectedAcademicYear(@PathVariable String student_id, @PathVariable String course_id, @PathVariable String academic_year, @PathVariable String exam_type){
        return arService.getSelectedStudentSelectedExamMarksBySelectedCourseAndSelectedAcademicYear(student_id, course_id, academic_year, exam_type);


        /*Usage
            UpdateABPage
         */
    }

    @PutMapping("/updateStudentScore")      //Update selected student grade with medical submissions
    public int updateStudentScore(@RequestBody UpdateABDTO updateEStarDTO){
        return arService.updateStudentScore(updateEStarDTO);

        /*Usage
            UpdateABPage
         */
    }



//    @GetMapping("/findAllStudentMarksRemainingToApprove/{approval_level}/{course_id}")
//    public List<MarksDTO> findAllStudentMarksRemainingToApprove(@PathVariable String approval_level, @PathVariable String course_id){
//        List<MarksDTO> joinedData=arService.findAllStudentMarksRemainingToApprove(approval_level,course_id);
//        return joinedData;
//    }
    /*---------------------------------------------------------------------------------------- Controller for marks table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Controller for grade table ----------------------------START-------------*/
    @PutMapping("/updateStudentFinalGrade")     //Update selected student's Final grade to WH
    public void updateStudentFinalGrade(@RequestBody GradeDTO gradeDTO){
        arService.updateStudentFinalGrade(gradeDTO);



        /*Usage
            UpdateABPage
         */
    }

    @GetMapping("/findAllStudentsGrade/{course_id}")     //Get all student grades of selected course module
    public List<GradeDTO> findAllStudentGrade(@PathVariable String course_id){
        return arService.findAllStudentMarksGrade(course_id);

        /*Usage
            ViewMarksTable
         */
    }

    @GetMapping("/findSelectedStudentGrade/{course_id}/{student_id}")     //Get selected student grades of selected course module
    public List<GradeDTO> findSelectedStudentGrade(@PathVariable String course_id, @PathVariable String student_id){
        return arService.findSelectedStudentMarksGrade(course_id,student_id);


        /*Usage
            UpdateABPage
            ViewMarksTable
         */
    }

    /*---------------------------------------------------------------------------------------- Controller for grade table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Controller for approval table ----------------------------START-------------*/


    @GetMapping("/getNotApprovedCoursesByLevelSemester/{level}/{semester}/{approval_level}/{academic_year}")            //Get * from marks Approval level table by selected level, semester, academic year and where approval level is not equal to provided level
    public List<MarksApprovalLevelDTO> getNotApprovedCoursesByLevelSemester(@PathVariable String level,@PathVariable String semester, @PathVariable String approval_level, @PathVariable String academic_year){
        return arService.getNotApprovedCoursesByLevelSemester(level,semester, approval_level, academic_year);

        /*Usage
            CertifyMarksPage
         */
    }


    @GetMapping("/getMarksApprovalLevelBySelectedCourseAndAcademicYear/{course_id}/{academic_year}")
    public List<MarksApprovalLevelDTO> getMarksApprovalLevelBySelectedCourseAndAcademicYear(@PathVariable String course_id, @PathVariable String academic_year){
        return arService.getMarksApprovalLevelBySelectedCourseAndAcademicYear(course_id,academic_year);

        /*Usage
            ViewMarksTableValidation
         */
    }


    /*---------------------------------------------------------------------------------------- Controller for approval table ----------------------------END-------------*/







    /*---------------------------------------------------------------------------------------- Controller for academic_year_details table ----------------------------START-------------*/
    @GetMapping("/getAcademicYearDetails")
    public List<AcademicYearDetailsDTO> getAcademicYearDetails(){
        return arService.getAcademicYearDetails();


        /*Usage
            UpdateABPage
            CreateResultBoard
         */
    }

    /*---------------------------------------------------------------------------------------- Controller for academic_year_details table ----------------------------END-------------*/








    /*---------------------------------------------------------------------------------------- Controller for User table ----------------------------START-------------*/

    @GetMapping("/findAllUserDetailsBySelectedRole/{role}")        //Get all user details by selected role
    public List<UserDTO> findAllUserDetailsBySelectedRole(@PathVariable String role){
        return arService.findAllUserDetailsBySelectedRole(role);
        /*Usage
            CreateResultBoard
        */

    }



    @GetMapping("/getAllCourseCoordinatorsBySelectedAcademicYearDepartmentLevelSemester/{academic_year}/{department_id}/{level}/{semester}")      //Get all course coordinator details by selected academic year department level and semester
    public List<UserDTO> getAllCourseCoordinatorsBySelectedAcademicYearDepartmentLevelSemester(@PathVariable String academic_year, @PathVariable String department_id, @PathVariable String level, @PathVariable String semester){
        return arService.getAllCourseCoordinatorsBySelectedAcademicYearDepartmentLevelSemester(academic_year, department_id, level, semester);
        /*Usage
            CreateResultBoard
        */

    }




    /*---------------------------------------------------------------------------------------- Controller for User table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Controller for result board table ----------------------------START-------------*/
    @GetMapping("/isResultBoardAvailable/{department}/{level}/{semester}/{academic_year}")                  //Get result board availability
    public boolean isResultBoardAvailable(@PathVariable String department,@PathVariable String level,@PathVariable String semester,@PathVariable String academic_year){
        return arService.isResultBoardAvailable(department, level, semester, academic_year);
    }

    @GetMapping("/getCreatedResultBoardList")                  //Get created result board list
    public List<ResultBoardDTO> getCreatedResultBoardList(){
        return arService.getCreatedResultBoardList();
    }


    /*---------------------------------------------------------------------------------------- Controller for result board table ----------------------------END-------------*/

}
