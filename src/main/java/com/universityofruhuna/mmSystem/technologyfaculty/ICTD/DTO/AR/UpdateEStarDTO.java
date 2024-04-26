package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateEStarDTO {
    private String course_id;
    private String student_id;
    private String new_grade;
    private String exam_type;
    private String academic_year;

    public String getCourse_id() {
        return course_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getNew_grade() {
        return new_grade;
    }

    public String getExam_type() {
        return exam_type;
    }

    public String getAcademic_year() {
        return academic_year;
    }
}
