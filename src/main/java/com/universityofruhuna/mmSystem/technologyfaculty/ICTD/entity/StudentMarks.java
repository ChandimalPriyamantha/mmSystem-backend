package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "grade")
public class StudentMarks
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String student_id;

    private String course_id;

    private String level;

    private String semester;

    private double overall_score;

    private String grade;

}
