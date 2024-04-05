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
    private String user_id;
    private String first_name;
    private String second_name;
    private String user_name;
    private String email;
    private String password;
    private Date registered_year;
    private String role;
}
