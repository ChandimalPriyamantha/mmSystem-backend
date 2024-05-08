package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "studentregcourses_with_an")
@Data
public class StudentCourseEnroll {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Integer Id;

@Column(name = "course_id")
private String courseId;

@Column(name = "student_id")
private String studentId;

@Column(name = "assignment_name")
private String assignmentName;

}
