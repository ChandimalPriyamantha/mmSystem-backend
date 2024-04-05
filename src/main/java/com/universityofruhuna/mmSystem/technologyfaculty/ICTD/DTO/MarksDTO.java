package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarksDTO {
    private int id;
    private String student_id;
    private String course_id;
    private String academic_year;
    private String level;
    private String semester;
    private String Assignment_type;
    private String Assignment_score;


}
