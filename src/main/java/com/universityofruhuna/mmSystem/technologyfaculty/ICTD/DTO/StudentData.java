package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class StudentData
{
    private String student_id;
    private String student_name;

    private List<ObjectDTO> ca;

    private List<ObjectDTO> end;

    private String total_final_marks;

    private String total_rounded_marks;

    private String grade;

    private String gpv;

    private String ca_eligibility;
}
