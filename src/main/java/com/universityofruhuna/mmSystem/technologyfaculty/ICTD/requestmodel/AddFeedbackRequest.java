package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddFeedbackRequest {

    private String role;

    private String component;

    private String feedback;

    private String date;

    private String signature;


}
