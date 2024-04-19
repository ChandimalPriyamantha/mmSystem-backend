package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "students")
public class StudentDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String student_id;
    private String full_name;
    private String name_with_initials;
    private String user_name;
    private String email;
    private String password;
    private Date registered_year;



}
