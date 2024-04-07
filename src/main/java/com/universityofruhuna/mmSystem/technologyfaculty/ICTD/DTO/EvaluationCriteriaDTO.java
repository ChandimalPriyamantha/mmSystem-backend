package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EvaluationCriteriaDTO
{
    private int id;

    private String course_id;

    private String assessment_type;

    private int no_of_conducted;

    private int no_of_taken;

    private int percentage;

    private String description;
}
