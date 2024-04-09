package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CalculationsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.CalculationsRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CalculationsService
{
    @Autowired
    private CalculationsRepo calculationsRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<CalculationsDTO> getMarksCalculations(String course_id)
    {
        return modelMapper.map(calculationsRepo.getCalculationresults(course_id),new TypeToken<ArrayList<CalculationsDTO>>(){}.getType());
    }
}
