package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO;

import lombok.*;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Marks_approved_logDTO
{
    private int id;
    private String course_id;
    private int level;
    private int semester;
    private String approved_user_id;
    private String approval_level;
    private String academic_year;
    private String date_time;
    private String department_id;
    private String signature;
}
