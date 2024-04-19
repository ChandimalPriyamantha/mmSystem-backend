package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AttendanceEligibilityDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.MedicalDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AttendanceEligibilityRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AttendanceEligibility;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AttendanceEligibilityService
{
    @Autowired
    ResponseDTO responseDTO;
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


    public ResponseDTO getAllAttendance(){
        List<AttendanceEligibility> attendanceEligibilities = attendanceEligibilityRepo.findAll();
        if (attendanceEligibilities.isEmpty()){
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Attendances not found!");
        }else {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(modelMapper.map(attendanceEligibilities, new TypeToken<ArrayList<AttendanceEligibilityDTO>>(){}.getType()));
            responseDTO.setMessage("Attendances found!");
        }
        return responseDTO;
    }
    public ResponseDTO insertAttendancesAsBulk(List<AttendanceEligibilityDTO> attendanceEligibilityDTOS){
        
    }
    public ResponseDTO insertAAttendance(){}
    public ResponseDTO getAAttendanceById(){}
    public ResponseDTO updateAAttendanceById(){}
    public ResponseDTO deleteAAttendanceById(){}




}
