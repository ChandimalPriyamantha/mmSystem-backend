package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.GPADTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.GPARepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GPAService
{
    @Autowired
    private GPARepo gpaRepo;

    @Autowired
    ModelMapper mp;

    public GPADTO getGPAByStID(String student_id)
    {
        return mp.map(gpaRepo.findGPAByStId(student_id),GPADTO.class);
    }
}
