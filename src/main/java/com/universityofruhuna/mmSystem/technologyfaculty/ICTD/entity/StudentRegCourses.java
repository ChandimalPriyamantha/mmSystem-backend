package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentCourseId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "studentregcourses")
@IdClass(StudentCourseId.class)
public class StudentRegCourses
{

    private int id;
    @Id
    private String student_id;
    @Id
    private String course_id;

    private String academic_year;
}
