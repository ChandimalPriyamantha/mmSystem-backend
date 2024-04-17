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
    private int course_level;
    private int course_semester;
    private String academic_year;
    private String approval_level;
}
