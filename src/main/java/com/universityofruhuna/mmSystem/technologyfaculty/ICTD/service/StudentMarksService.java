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


    public String editMarks(StudentMarksDTO studentMarksDTO){
        if (studentMarksRepo.existsById(studentMarksDTO.getId())){
            studentMarksRepo.save(mp.map(studentMarksDTO,StudentMarks.class));
            return VarList.RIP_SUCCESS;
        }else {
            return VarList.RIP_NO_DATA_FOUND;
        }

    }

    /*Lakindu-Start--------------------*/
    public List<Object[]> findAllStudentMarksRemainingToApprove(String approval_level,String course_id ){


        return studentMarksRepo.findAllStudentMarksRemainingToApprove(approval_level,course_id);

    }
}
