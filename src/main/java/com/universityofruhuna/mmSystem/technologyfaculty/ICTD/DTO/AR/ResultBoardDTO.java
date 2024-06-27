package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultBoardDTO {
    private int id;
    private String department;
    private int level;
    private int semester;
    private String academic_year;
    private String status;
    private String created_date_time;
}
