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
@Table(name = "user")
public class StudentDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user_id;
    private String first_name;
    private String second_name;
    private String user_name;
    private String email;
    private String password;
    private Date registered_year;
    private String role;


}
