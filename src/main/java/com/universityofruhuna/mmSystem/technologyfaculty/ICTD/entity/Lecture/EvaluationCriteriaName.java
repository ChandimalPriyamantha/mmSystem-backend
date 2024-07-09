package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "evaluationcriteria_name")
@Data
public class EvaluationCriteriaName {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "assignment_name")
    private String assignmentName;

    @Column(name = "evaluationcriteria_id")
    private String evaluationCriteriaId;

}
