package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CourseNameIdDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentMarksDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.StudentMarksRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.StudentMarks;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
@Transactional
public class StudentMarksService
{
    @Autowired
    private StudentMarksRepo studentMarksRepo;

    @Autowired
    private ModelMapper mp;

    @Autowired
    private ResponseDTO responseDTO;

 public ResponseDTO  findStudentMarksByLevelSem(String level, String sem)
    {

        List<StudentMarks> markList=studentMarksRepo.findStudentMarksByLevelSemester(level,sem);
        if(!markList.isEmpty())
        {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(mp.map(markList,new TypeToken<ArrayList<StudentMarksDTO>>(){}.getType()));
            responseDTO.setMessage("Student marks found");
        }
        else {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Student marks  not found");
        }

        return responseDTO;
    }

    public ResponseDTO  findApprovedStudentMarksByLevelSem(String level, String sem,String approved_level)
    {

        List<StudentMarks> markList=studentMarksRepo.findStudentMarksByLS(level,sem,approved_level);
        if(!markList.isEmpty())
        {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(mp.map(markList,new TypeToken<ArrayList<StudentMarksDTO>>(){}.getType()));
            responseDTO.setMessage("Student marks found");
        }
        else {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Student marks  not found");
        }

        return responseDTO;
    }

    public ResponseDTO getMarksforCourseById(String id) {


            List<StudentMarks> list=studentMarksRepo.findCoursecodeOverallScoreByStId(id);
            if(!list.isEmpty())
            {
                responseDTO.setCode(VarList.RIP_SUCCESS);
                responseDTO.setContent(mp.map( list,new TypeToken<ArrayList<StudentMarksDTO>>(){}.getType()));
                responseDTO.setMessage("Data found");
            }
            else
            {
                responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
                responseDTO.setContent(null);
                responseDTO.setMessage("No data found");
            }
            return responseDTO;
    }

    public ResponseDTO getMarksbyC(String course_id)
    {
        List<StudentMarks> list=studentMarksRepo.findMarksByCourse(course_id);

        if(!list.isEmpty())
        {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(mp.map(list,new TypeToken<ArrayList<StudentMarksDTO>>(){}.getType()));
            responseDTO.setMessage("Data found");
        }
        else
        {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("No Data found");
        }
        return responseDTO;
    }

    public ResponseDTO getMarksbySC(String course_id,String student_id)
    {
        StudentMarks studentMarks=studentMarksRepo.findMarksByCS(course_id,student_id);

        if(studentMarks==null)
        {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("No data found");
        }
        else
        {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(mp.map(studentMarks,StudentMarksDTO.class));
            responseDTO.setMessage("Data found");
        }
            return responseDTO;
    }



}
