package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.CourseRepo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String course_id;
    private String course_name;
    private int hours;
    private String type;
    private double credit;
    private String department_id;
    private int level;
    private int semester;


}
