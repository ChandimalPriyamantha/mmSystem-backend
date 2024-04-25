package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDetailsDTO {
    private int id;
    private String student_id;
    private String full_name;
    private String name_with_initials;
    private String user_name;
    private String email;
    private String password;
    private String registered_year;

}
