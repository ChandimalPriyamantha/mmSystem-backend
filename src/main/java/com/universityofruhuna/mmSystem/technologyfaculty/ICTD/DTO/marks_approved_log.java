package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class marks_approved_log
{
    private int id;
    private String course_id;
    private String approved_user_id;
    private String approved_user_level;
    private String academic_year;
    private LocalDateTime date_time;
}
