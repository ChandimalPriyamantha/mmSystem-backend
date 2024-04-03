package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "mark_approved_level")
public class MarksApprovalLevel {

    @Id
    private int approval_id;
    private String course_id;
    private String student_id;
    private String approval_level;
    private String approved_year;

}
