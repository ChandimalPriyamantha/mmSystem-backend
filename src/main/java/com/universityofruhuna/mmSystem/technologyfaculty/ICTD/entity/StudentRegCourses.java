package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.StudentCourseId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
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
    @Id
    private String student_id;
    @Id
    private String course_id;

    private String academic_year;
}
