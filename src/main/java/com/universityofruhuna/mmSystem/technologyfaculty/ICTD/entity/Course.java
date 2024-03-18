package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    private String course_id;
    private String course_name;
    private int hours;
    private String type;
    private double credit;
    private String department_id;
    private int level;
    private int semester;

}
