package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lcr")
@Data
public class LectureCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer ID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "course_code")
    private String courseCode;
}
