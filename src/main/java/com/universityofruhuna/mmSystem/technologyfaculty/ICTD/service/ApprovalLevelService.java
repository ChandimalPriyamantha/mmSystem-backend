package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.Marks_approved_logDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.ApprovalLevelRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Approved_user_levelRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Marks_approved_log;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Blob;
import java.time.LocalDateTime;

@Service
@Transactional
public class ApprovalLevelService {

    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ApprovalLevelRepo approvalLevelRepo;

    @Autowired
    private Approved_user_levelRepo approved_user_levelRepo;




    public ResponseDTO updateApprovalLevelByDepartment(Marks_approved_logDTO marksApprovedLogDTO) {

        try {

            approved_user_levelRepo.save(modelMapper.map(marksApprovedLogDTO, Marks_approved_log.class));
            approvalLevelRepo.updateApprovedLevel(marksApprovedLogDTO.getCourse_id(),marksApprovedLogDTO.getAcademic_year(),marksApprovedLogDTO.getApproval_level());
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setMessage("Successfully updated approval level");
            responseDTO.setContent(marksApprovedLogDTO);
        } catch (RuntimeException e) {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setMessage("Error updating approval level: " + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return responseDTO;
    }

    public ResponseDTO updateApprovalLevelByDeanOffice(String level,String sem,String academic_year,String approval_level) {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        try {
            approvalLevelRepo.updateApprovedLevelByDean(level,sem, academic_year, approval_level);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setMessage("Successfully updated approval level");
            responseDTO.setContent(null);
        } catch (RuntimeException e) {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setMessage("Error updating approval level: " + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return responseDTO;
    }

    public ResponseDTO getSignature( String course_id, String approval_level,String academic_year)
    {
        try {
            Marks_approved_log marksApprovedLog=approved_user_levelRepo.getSignature(course_id,approval_level,academic_year);
            if(!marksApprovedLog.equals(null))
            {
                responseDTO.setCode(VarList.RIP_SUCCESS);
                responseDTO.setMessage("successfuly get");
                responseDTO.setContent(modelMapper.map(marksApprovedLog,Marks_approved_logDTO.class));
            }
            else
            {
                responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
                responseDTO.setMessage("no signature");
                responseDTO.setContent(null);
            }

        } catch (RuntimeException e) {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return responseDTO;
    }


}
