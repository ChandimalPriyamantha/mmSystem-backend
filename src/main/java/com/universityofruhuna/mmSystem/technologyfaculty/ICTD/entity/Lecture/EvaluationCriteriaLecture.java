package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "evaluationcriteria")
@Data
public class EvaluationCriteriaLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "type")
    private String type;

    @Column(name = "assignment_type")
    private String assignmentType;

    @Column(name = "no_of_conducted")
    private String noOfConducted;

    @Column(name = "no_of_taken")
    private String no_of_taken;

    @Column(name = "percentage")
    private String percentage;

    @Column(name = "description")
    private String description;

    @Column(name = "evaluationcriteria_id")
    private String evaluationCriteriaId;
}
