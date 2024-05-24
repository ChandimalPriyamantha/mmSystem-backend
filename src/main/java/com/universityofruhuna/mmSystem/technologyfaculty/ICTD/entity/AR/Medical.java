package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "medical")
public class Medical {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String student_id;
    private String course_id;
    private String academic_year;
    private String exam_type;
    private String medical_state;


}
