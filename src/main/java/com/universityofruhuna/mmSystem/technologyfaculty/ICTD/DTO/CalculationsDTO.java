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
    private String type;
    private String mark;
    private String percentage;
    private String description;

}
