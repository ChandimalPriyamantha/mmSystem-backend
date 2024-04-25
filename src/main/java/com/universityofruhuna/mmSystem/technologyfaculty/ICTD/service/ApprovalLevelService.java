package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.ApprovalLevelRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@Transactional
public class ApprovalLevelService {

    @Autowired
    ResponseDTO responseDTO;

    @Autowired
    private ApprovalLevelRepo approvalLevelRepo;

    public ResponseDTO updateApprovalLevel(String course_id, String academic_year, String approval_level) {

        try {
            approvalLevelRepo.updateApprovedLevel(course_id, academic_year, approval_level);
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

    public ResponseDTO updateApprovalLevel(String level,String sem, String academic_year, String approval_level) {

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
}
