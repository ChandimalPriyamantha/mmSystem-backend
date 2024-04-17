package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CalculationsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.CalculationsRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Calculations;
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
        List<Calculations> calculations=calculationsRepo.getCalculationresults(course_id);

        if(calculations.isEmpty())
        {
            return null;
        }
        else
        return modelMapper.map(calculations,new TypeToken<ArrayList<CalculationsDTO>>(){}.getType());
    }

    public List<CalculationsDTO> getMarksCalculations(String course_id,String student_id)
    {
        List<Calculations> calculations=calculationsRepo.getCalculationresults(course_id,student_id);
        if(calculations.isEmpty())
        {
            return null;
        }
        else
        return modelMapper.map(calculations,new TypeToken<ArrayList<CalculationsDTO>>(){}.getType());
    }
}
