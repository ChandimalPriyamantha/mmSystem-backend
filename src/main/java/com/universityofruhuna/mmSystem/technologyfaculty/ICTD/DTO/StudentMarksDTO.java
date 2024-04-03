package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentMarksDTO
{
    private int id;

    private String student_id;

    private String course_id;

    private String level;

    private String semester;

    private double overall_score;

    private String grade;

}
