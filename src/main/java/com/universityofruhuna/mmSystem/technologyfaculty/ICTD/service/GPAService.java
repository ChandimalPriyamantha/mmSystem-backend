package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.GPADTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.GPARepo;
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
public class GPAService
{
    @Autowired
    private GPARepo gpaRepo;

    @Autowired
    ModelMapper mp;

    public List<GPADTO> getGPAByLevelSemester(String level,String semester)
    {
        List<GPA> list=gpaRepo.findGPAByLevelSemester(level,semester);

        if(list.isEmpty())
        {
            return null;
        }
        else
            return mp.map(list,new TypeToken<ArrayList<GPADTO>>(){}.getType());
    }

    public List<GPADTO> getGPAByStID(String student_id)
    {
        List<GPA> list=gpaRepo.findGPAByStId(student_id);

        if(list.isEmpty())
        {
            return  null;
        }
        else
        return mp.map(list,new TypeToken<ArrayList<GPADTO>>(){}.getType());
    }
}
