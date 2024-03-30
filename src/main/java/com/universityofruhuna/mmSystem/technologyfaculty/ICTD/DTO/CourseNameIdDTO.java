package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO;

import lombok.*;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CourseNameIdDTO
{
    private String course_id;
    private String course_name;
}
