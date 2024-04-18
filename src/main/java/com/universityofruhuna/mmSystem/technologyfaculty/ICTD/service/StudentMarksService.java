package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

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




    public List<StudentMarksDTO>  findStudentMarksByLevelSem(String level, String sem)
    {

        List<StudentMarks> markList=studentMarksRepo.findStudentMarksByLevelSemester(level,sem);


        return mp.map(markList,new TypeToken<ArrayList<StudentMarksDTO>>(){}.getType());
    }


    public String editMarks(List<StudentMarksDTO> studentMarksDTO){
      //  if (studentMarksRepo.existsById(studentMarksDTO.getId())){
            studentMarksRepo.saveAll(mp.map(studentMarksDTO,new TypeToken<ArrayList<StudentMarks>>(){}.getType()));
        //    return VarList.RIP_SUCCESS;
      //  }else {
            return VarList.RIP_NO_DATA_FOUND;
     //   }

    }


    public List<StudentMarksDTO> getMarksforCourseById(String id) {

            List<StudentMarksDTO> studentMarks =mp.map( studentMarksRepo.findCoursecodeOverallScoreByStId(id),new TypeToken<ArrayList<StudentMarksDTO>>(){}.getType());

            return studentMarks;

    }

    public List<StudentMarksDTO> getMarksbyC(String course_id)
    {

        return mp.map(studentMarksRepo.findMarksByCourse(course_id),new TypeToken<ArrayList<StudentMarksDTO>>(){}.getType());


    }

    public StudentMarksDTO getMarksbySC(String course_id,String student_id)
    {
        StudentMarks studentMarks=studentMarksRepo.findMarksByCS(course_id,student_id);

        if(studentMarks==null)
        {
            return null;
        }
        else

        return mp.map(studentMarks,StudentMarksDTO.class);
    }



}
