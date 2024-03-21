package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.ExamScore;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.AR.ARService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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



    @GetMapping("/findAllStudentMarksRemainingToApprove/{approval_level}/{course_id}")
    public List<MarksDTO> findAllStudentMarksRemainingToApprove(@PathVariable String approval_level, @PathVariable String course_id){
        List<MarksDTO> joinedData=arService.findAllStudentMarksRemainingToApprove(approval_level,course_id);
        return joinedData;
    }



}
