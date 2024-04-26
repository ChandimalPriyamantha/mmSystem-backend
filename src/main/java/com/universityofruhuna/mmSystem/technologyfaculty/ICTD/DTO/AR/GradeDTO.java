package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GradeDTO {
    private int id;
    private String student_id;
    private String course_id;
    private int level;
    private int semester;
    private double overall_score;
    private String grade;
}
