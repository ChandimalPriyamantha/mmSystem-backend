package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "feedback")
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "component")
    private String component;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "date")
    private String date;

    @Column(name = "signature")
    private String signature;


}
