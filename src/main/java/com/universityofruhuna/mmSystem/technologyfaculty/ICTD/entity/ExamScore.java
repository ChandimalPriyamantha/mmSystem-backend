package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "marks")
@Data
public class ExamScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name="student_id")
    private String studentID;

    @Column(name="course_id")
    private String courseID;

    @Column(name="academic_year")
    private String year;

    @Column(name="assignment_type")
    private String assignmentType;

    @Column(name="assignment_score")
    private Double assignmentScore;

    @Column(name = "level")
    private String level;

    @Column(name = "semester")
    private String semester;
}
