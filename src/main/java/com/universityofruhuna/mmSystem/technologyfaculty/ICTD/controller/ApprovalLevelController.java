package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.ApprovalLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/approvalLevel")
public class ApprovalLevelController
{
    @Autowired
    ApprovalLevelService approvalLevelService;
    @PutMapping("/updateApprovalLevel/{course_id}/{academic_year}/{approval_level}")
    public ResponseEntity updateApprovalLevel(@PathVariable String course_id,@PathVariable String academic_year,@PathVariable String approval_level)
    {
        ResponseDTO responseDTO=approvalLevelService.updateApprovalLevel(course_id,academic_year,approval_level);
        if(responseDTO.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND );
        }
    }

    @PutMapping("updateApprovalLevelByDean/{department_id}/{level}/{sem}/{academic_year}/{approval_level}")
    public ResponseEntity updateApprovalLevelByDean(@PathVariable String department_id,@PathVariable String level,@PathVariable String sem,@PathVariable String academic_year,@PathVariable String approval_level)
    {
        ResponseDTO responseDTO=approvalLevelService.updateApprovalLevel(department_id,level,sem,academic_year,approval_level);
        if(responseDTO.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND );
        }
    }
}
