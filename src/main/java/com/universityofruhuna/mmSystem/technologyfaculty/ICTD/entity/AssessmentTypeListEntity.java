package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table()
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssessmentTypeListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String assessment_type_name;
}
