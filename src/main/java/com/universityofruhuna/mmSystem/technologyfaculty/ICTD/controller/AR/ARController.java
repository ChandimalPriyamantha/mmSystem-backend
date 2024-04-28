package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.*;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AR.ARService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.http.parser.MediaTypeCache;
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

    @GetMapping("/findCoursesByDepartmentLevelSemester/{department_id}/{level}/{semester}/{approval_level}")
    public List<CourseDTO> findCoursesByDepartmentLevelSemester(@PathVariable String department_id ,@PathVariable int level, @PathVariable int semester, @PathVariable String approval_level){
        return arService.findCoursesByDepartmentLevelSemester(department_id,level,semester,approval_level);
    }

    @GetMapping("/findAllCourses")
    public List<CourseDTO> findAllCourses(){
        return arService.getAllCourses();
    }





    //this method retrieve all records match with approval_level, course_id
//    @GetMapping("/findAllStudentMarksRemainingToApproveByStuId/{approval_level}/{course_id}/{student_id}")
//    public List<MarksDTO> findAllStudentMarksRemainingToApproveByStuId(@PathVariable String approval_level, @PathVariable String course_id,@PathVariable String student_id){
//        List<MarksDTO> joinedData=arService.findAllStudentMarksRemainingToApproveByStuId(approval_level,course_id,student_id);
//        return joinedData;
//    }


    //This method is to update mark approval level of mark approval_level_table with passing  new_approval_level, course_id,  student_id,  old_approval_level,  approved_year
//    @PostMapping("/updateMarksApprovalLevelByAllParameters/{new_approval_level}/{course_id}/{student_id}/{old_approval_level}/{approved_year}")
//    public Boolean updateMarksApprovalLevelByAllParameters(@PathVariable String new_approval_level,@PathVariable String course_id, @PathVariable String student_id, @PathVariable String old_approval_level, @PathVariable String approved_year){
//       return arService.updateMarksApprovalLevelByAllParameters( new_approval_level, course_id,  student_id,  old_approval_level,  approved_year);
//    }







    /*---------------------------------------------------------------------------------------- Controller for course table ----------------------------START-------------*/
    @GetMapping("/getViewMarksCourseList/{level}/{semester}/{department_id}")           //Get all course details of selected department by level and semester
    public List<CourseDTO> getViewMarksCourseList (@PathVariable String level, @PathVariable String semester, @PathVariable String department_id){

        return arService.getViewMarksCourseList(level, semester,department_id);
    }

    /*---------------------------------------------------------------------------------------- Controller for course table ----------------------------END-------------*/





    /*---------------------------------------------------------------------------------------- Controller for medical table ----------------------------START------------*/
    @GetMapping("/getAllMedicalSubmissionsByYear/{academic_year}")    //controller to get all medical list by selected academic year
    public List<MedicalDTO> getAllMedicalSubmissionsByYear(@PathVariable String academic_year){
        return arService.getAllMedicalSubmissionsByYear(academic_year);
    }

    @GetMapping("/getAllMedicalSubmissions")    //controller to get all medical list by selected academic year
    public List<MedicalDTO> getAllMedicalSubmissions(){
        return arService.getAllMedicalSubmissions();
    }

    @GetMapping("/getSelectedStudentMedicalDetails/{student_id}/{course_id}/{academic_year}/{exam_type}")   //Controller to get selected student's medical details for selected exam
    public List<MedicalDTO> getSelectedStudentMedicalDetails(@PathVariable String student_id, @PathVariable String course_id, @PathVariable String academic_year, @PathVariable String exam_type){
        return arService.getSelectedStudentMedicalDetails(student_id, course_id, academic_year, exam_type);
    }


    /*---------------------------------------------------------------------------------------- Controller for medical table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Controller for marks table ----------------------------START-------------*/


    @GetMapping("/getEStarDetails")      //Get student id and other details from marks table where grade is E*
    public List<Object[]> getEStarDetails(){
        return arService.getEStarDetails();
    }

    @GetMapping("/getEStarDetailsByCourseId/{course_id}")      //Get student id and other details from marks table where grade is E*        This is for view marks table to identify is there E* for the subject
    public List<Object[]> getEStarDetailsByCourseId(@PathVariable String course_id){
        return arService.getEStarDetailsByCourseId(course_id);
    }

    @PutMapping("/updateStudentGrade")      //Update selected student grade with medical submissions
    public int updateStudentGrade(@RequestBody UpdateEStarDTO updateEStarDTO){
        return arService.updateStudentGrade(updateEStarDTO);
    }

//    @GetMapping("/findAllStudentMarksRemainingToApprove/{approval_level}/{course_id}")
//    public List<MarksDTO> findAllStudentMarksRemainingToApprove(@PathVariable String approval_level, @PathVariable String course_id){
//        List<MarksDTO> joinedData=arService.findAllStudentMarksRemainingToApprove(approval_level,course_id);
//        return joinedData;
//    }
    /*---------------------------------------------------------------------------------------- Controller for marks table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Controller for grade table ----------------------------START-------------*/
    @PutMapping("/updateStudentFinalGrade")     //Update selected student's Final grade to WH
    public void updateStudentFinalGrade(@RequestBody UpdateEStarDTO updateEStarDTO){
        arService.updateStudentFinalGrade(updateEStarDTO);
    }

    @GetMapping("/findAllStudentsGrade/{course_id}")     //Get all student grades of selected course module
    public List<GradeDTO> findAllStudentGrade(@PathVariable String course_id){
        return arService.findAllStudentMarksGrade(course_id);
    }

    @GetMapping("/findSelectedStudentGrade/{course_id}/{student_id}")     //Get selected student grades of selected course module
    public List<GradeDTO> findSelectedStudentGrade(@PathVariable String course_id, @PathVariable String student_id){
        return arService.findSelectedStudentMarksGrade(course_id,student_id);
    }

    /*---------------------------------------------------------------------------------------- Controller for grade table ----------------------------END-------------*/






    /*---------------------------------------------------------------------------------------- Controller for approval table ----------------------------START-------------*/

    @GetMapping("/getNotApprovedCoursesByLevelSemester/{level}/{semester}/{approval_level}/{academic_year}")
    public List<MarksApprovalLevelDTO> getNotApprovedCoursesByLevelSemester(@PathVariable String level,@PathVariable String semester, @PathVariable String approval_level, @PathVariable String academic_year){
        return arService.getNotApprovedCoursesByLevelSemester(level,semester, approval_level, academic_year);
    }


    /*---------------------------------------------------------------------------------------- Controller for approval table ----------------------------END-------------*/

}
