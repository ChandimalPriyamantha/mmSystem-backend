package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "mark_approved_level")
public class MarksApprovalLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int approval_id;
    private String course_id;
    private int course_level;
    private int course_semester;
    private String academic_year;
    private String approval_level;


}
