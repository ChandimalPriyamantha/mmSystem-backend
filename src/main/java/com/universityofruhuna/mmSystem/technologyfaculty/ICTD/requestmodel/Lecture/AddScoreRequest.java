package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel.Lecture;


import lombok.Data;

@Data
public class AddScoreRequest {

    private String studentID;
    private String courseID;
    private String year;
    private String assignmentType;
    private Double assignmentScore;
    private String level;
    private String semester;
    private String assignmentName;

}
