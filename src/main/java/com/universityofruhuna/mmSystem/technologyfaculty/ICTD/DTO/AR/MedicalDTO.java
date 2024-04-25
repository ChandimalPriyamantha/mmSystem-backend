package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicalDTO {
    private int id;
    private String student_id;
    private String course_id;
    private Year academic_year;
    private String exam_type;
    private String medical_state;
}
