package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.Marks_approved_logDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.ApprovalLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/approvalLevel")
public class ApprovalLevelController
{
    @Autowired
    ApprovalLevelService approvalLevelService;
    @PostMapping("/updateApprovalLevel")
    public ResponseEntity updateApprovalLevel(@RequestBody  Marks_approved_logDTO marksApprovedLogDTO)
    {
        ResponseDTO responseDTO=approvalLevelService.updateApprovalLevelByDepartment(marksApprovedLogDTO);
        if(responseDTO.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(responseDTO,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(responseDTO,HttpStatus.NOT_FOUND );
        }
    }

    @PutMapping("updateApprovalLevelByDean/{level}/{sem}/{academic_year}/{approval_level}")
    public ResponseEntity updateApprovalLevelByDeanOffice(@PathVariable String level,@PathVariable String sem,@PathVariable String academic_year,@PathVariable String approval_level)
    {
        ResponseDTO responseDTO=approvalLevelService.updateApprovalLevelByDeanOffice(level,sem,academic_year,approval_level);
        if(responseDTO.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(responseDTO,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND );
        }
    }

    @GetMapping("/getSignature/{course_id}/{approval_level}/{academic_year}")
    public ResponseEntity getSignature(@PathVariable String course_id,@PathVariable String approval_level,@PathVariable String academic_year)
    {
        ResponseDTO responseDTO=approvalLevelService.getSignature(course_id,approval_level,academic_year);
        if(responseDTO.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(responseDTO,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(responseDTO,HttpStatus.NOT_FOUND );
        }
    }
}
