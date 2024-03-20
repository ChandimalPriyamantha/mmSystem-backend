package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.GPADTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.GPARepo;
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

    public List<GPADTO> getGPAByStID(String student_id)
    {
        return mp.map(gpaRepo.findGPAByStId(student_id),new TypeToken<ArrayList<GPADTO>>(){}.getType());
    }
}
