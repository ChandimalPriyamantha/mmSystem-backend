package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "marks")
@Data
public class ARMarksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String student_id;
    private String course_id;
    private String academic_year;
    private String level;
    private String semester;
    private String assignment_type;
    private Double assignment_score;


}
