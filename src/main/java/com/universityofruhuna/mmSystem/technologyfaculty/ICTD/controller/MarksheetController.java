package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ObjectDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.StudentData;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.MarkSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/marksReturnSheet")
public class MarksheetController
{
    @Autowired
    MarkSheetService markSheetService;

    @GetMapping("getMarks/{course_id}")
    public List<StudentData> getMarks(@PathVariable String course_id )
    {
         return markSheetService.getData(course_id);
    }
}
