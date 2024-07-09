package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.VC;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mark_approved_level")
@Data
public class LevelForVC {

    @Id
    @Column(name = "approval_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "student_id")
    private String studentId;
//
//    @Column(name = "approval_level")
//    private String approvalLevel;

    @Column(name = "approved_year")
    private String approvalYear;

//    @OneToOne(targetEntity = GradeForVC.class, cascade = CascadeType.ALL)
//    @JoinColumns({
//            @JoinColumn(name="course_id", referencedColumnName="courseId"),
//            @JoinColumn(name="student_id", referencedColumnName="studentId")
//    })
//    private GradeForVC gradeForVC;
}
