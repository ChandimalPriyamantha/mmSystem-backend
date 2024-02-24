package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "examscore")
@Data
public class ExamScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    private String studentID;

    private String courseID;

    private String year;

    private String assignmentType;

    private Double assignmentScore;

    private String level;

    private String semester;
}
