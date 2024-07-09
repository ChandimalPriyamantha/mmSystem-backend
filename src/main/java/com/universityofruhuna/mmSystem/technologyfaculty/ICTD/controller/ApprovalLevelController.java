package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AssigncertifylecturerDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.Marks_approved_logDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.ApprovalLevelService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/assignCertifyLecturer")
    public void assignCertifyLecturer(@RequestBody  AssigncertifylecturerDTO assigncertifylecturerDTO)
    {
        approvalLevelService.assignCertifyLecturer(assigncertifylecturerDTO);
    }

    @PostMapping("/return")
    public ResponseEntity ReturnApprovalLevel(@RequestBody  Marks_approved_logDTO marksApprovedLogDTO)
    {
        ResponseDTO responseDTO=approvalLevelService.ReturnApprovalLevelByDepartment(marksApprovedLogDTO);
        if(responseDTO.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(responseDTO,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(responseDTO,HttpStatus.NOT_FOUND );
        }
    }

    @PostMapping("updateApprovalLevelByDean")
    public ResponseEntity updateApprovalLevelByDeanOffice(@RequestBody Marks_approved_logDTO marksApprovedLogDTO)
    {
        ResponseDTO responseDTO=approvalLevelService.updateApprovalLevelByDeanOffice(marksApprovedLogDTO);
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

    @GetMapping("/getSignature/{level}/{semester}/{department_id}/{approval_level}/{academic_year}")
    public ResponseEntity getSignature(@PathVariable int level,@PathVariable int semester,@PathVariable String department_id,@PathVariable String approval_level,@PathVariable String academic_year)
    {
        ResponseDTO responseDTO=approvalLevelService.getSignature(level,semester,department_id,approval_level,academic_year);
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
