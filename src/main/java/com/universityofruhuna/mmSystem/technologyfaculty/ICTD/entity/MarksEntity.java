package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "marks")
public class MarksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String student_id;
    private String course_id;
    private String academic_year;
    private String level;
    private String semester;
    private String Assignment_type;
    private String Assignment_score;



}
