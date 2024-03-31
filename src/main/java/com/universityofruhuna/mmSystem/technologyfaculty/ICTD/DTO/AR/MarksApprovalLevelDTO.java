package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarksApprovalLevelDTO {
    private int approval_id;
    private String course_id;
    private String student_id;
    private String approval_level;
    private String approved_year;
}
