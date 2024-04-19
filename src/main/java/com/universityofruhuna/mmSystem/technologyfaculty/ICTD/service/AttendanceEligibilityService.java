package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AttendanceEligibilityDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AttendanceEligibilityRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AttendanceEligibility;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AttendanceEligibilityService
{
    @Autowired
    private AttendanceEligibilityRepo attendanceEligibilityRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AttendanceEligibilityDTO getAttendanceEligibilityByStuIdCourseId(String course_id,String student_id)
    {
        AttendanceEligibility list=attendanceEligibilityRepo.getAttendanceByStuIdCourseId(course_id,student_id);

        if(list==null)
        {
            return  null;
        }
        else

        return modelMapper.map(list, AttendanceEligibilityDTO.class);

    }
}
