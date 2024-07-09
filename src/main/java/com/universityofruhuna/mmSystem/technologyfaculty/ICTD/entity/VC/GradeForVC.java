package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.VC;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "grade")
public class GradeForVC {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "level")
    private String level;

    @Column(name = "semester")
    private String semester;
//
//    @Column(name = "overall_score")
//    private String overallScore;

    @Column(name = "grade")
    private String grade;



}
