package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalculationsDTO
{
    private int id;
    private String student_id;

    private String course_id;

    private double quiz_avg;

    private double quiz_Percentage;

    private double mid_exam_percentage;

    private double total_ca_marks;

    private double end_exam_percentage;

}
