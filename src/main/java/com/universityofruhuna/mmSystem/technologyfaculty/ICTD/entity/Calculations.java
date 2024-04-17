package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="markcalculation")
public class Calculations
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String student_id;

    private String course_id;

    private double quiz_avg;

    private double quiz_Percentage;

    private double mid_exam_percentage;

    private double total_ca_marks;

    private double end_exam_percentage;


}
