package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MedicalDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentRegCoursesDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentRegisteredCourses;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.MarkSheetService;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentRegCoursesServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/studentRegCourses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentRegistedCourseController
{
    @Autowired
    private StudentRegCoursesServices studentRegCoursesServices;

    @Autowired
    MarkSheetService markSheetService;


    @GetMapping("/getStudentsByCourse/{course_id}")
    public ResponseEntity getStudentsByCourse(@PathVariable String course_id)
    {
        List<String> studentList=new ArrayList<>();

        ResponseDTO responseDTO=studentRegCoursesServices.getStudentsByCourseCode(course_id);

        List<StudentRegCoursesDTO> list= (List<StudentRegCoursesDTO>) responseDTO.getContent();



        if(responseDTO.getCode()== VarList.RIP_NO_DATA_FOUND)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            for (StudentRegCoursesDTO studentRegCoursesDTO : list)
            {
                studentList.add(studentRegCoursesDTO.getStudent_id());
            }
            return new ResponseEntity(studentList,HttpStatus.OK);

        }




    }



    @GetMapping("getallRegisteredStudents")
    public ResponseEntity<ResponseDTO> getallRegisteredStudents(){
        ResponseDTO allStudents = studentRegCoursesServices.getStudents();
        if (allStudents.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity<>(allStudents, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(allStudents,HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("insert_allRegisteredStudents")
    public ResponseEntity insert_allRegisteredStudents(@RequestBody List<StudentRegisteredCourses> list){
        ResponseDTO AllStudents = studentRegCoursesServices.insertAllStudents(list);
        if (AllStudents.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(AllStudents,HttpStatus.CREATED);

        }else{
            return new ResponseEntity(AllStudents,HttpStatus.BAD_REQUEST);
        }
    }




}
