package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "marks_approved_log")
public class marks_approved_log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String course_id;
    private String approved_user_id;
    private String approved_user_level;
    private String academic_year;
    private LocalDateTime date_time;

}
