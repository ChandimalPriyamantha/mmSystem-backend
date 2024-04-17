package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="evaluationcrieteria")
public class EvaluationCriteria
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String course_id;

    private String assessment_type;

    private int no_of_conducted;

    private int no_of_taken;

    private int precentage;

    private String description;

}
