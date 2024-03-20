package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="gpa")
public class GPA
{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    private String student_id;

    private String acadamic_year;

    private int level;

    private int semester;

    private double sgpa;

    private double cgpa;


}
