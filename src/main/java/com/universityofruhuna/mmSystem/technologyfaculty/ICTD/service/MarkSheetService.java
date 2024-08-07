package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.*;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.*;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MarkSheetService
{

        @Autowired
        private EvaluationCriteriaRepo evaluationCriteriaRepo;

        @Autowired
        private ModelMapper modelMapper;

        @Autowired
        private ResponseDTO responseDTO;

        @Autowired
        private MarksRepo marksRepo;

        @Autowired
        private CalculationsRepo calculationsRepo;

        @Autowired
        private StudentMarksRepo studentMarksRepo;

        @Autowired
        private StudentRegCoursesRepo studentRegCoursesRepo;
        List<EvaluationCriteria> evaluationCriteriaList;
        List<ObjectDTO> dataList=new ArrayList<>();
        List<MarksEntity> marksEntityList;
        List<Calculations> calculations;
        List<StudentMarks> studentMarksList;
        List<StudentRegCourses> studentRegCoursesList;
        @Autowired
        private StudentRepo studentRepo;
        Boolean CA=false;
        Boolean end=false;

        public void getEvaluationCriteria(String course_id)
        {
            evaluationCriteriaList=evaluationCriteriaRepo.getEvaluationCriteria(course_id);
        }


        public void getAllScoreByCourseId(String course_id){

            marksEntityList=marksRepo.findStudentMarksByCourseID(course_id);
        }

        public void getMarksCalculations(String course_id)
        {
             calculations=calculationsRepo.getCalculationresults(course_id);
        }

        public void getMarksbyC(String course_id)
        {
            studentMarksList=studentMarksRepo.findMarksByCourse(course_id);
        }


        public void getStudentsByCourseCode(String course_id)
        {
            studentRegCoursesList=studentRegCoursesRepo.getStudentsbyCourseCode(course_id);

        }

        public List<StudentData> getData(String course_id) {

            List<StudentData> list=new ArrayList<>();
            getEvaluationCriteria(course_id);
            getAllScoreByCourseId(course_id);
            getMarksCalculations(course_id);
            getMarksbyC(course_id);
            getStudentsByCourseCode(course_id);

            for (StudentRegCourses student : studentRegCoursesList) {
                List<ObjectDTO> caMarks = new ArrayList<>();
                List<ObjectDTO> endMarks=new ArrayList<>();

                for (EvaluationCriteria object : evaluationCriteriaList) {
                    if (object.getType().equals("CA")) {
                        CA = true;

                        if (object.getNo_of_conducted() > 1) {
                            for (MarksEntity markEntity : marksEntityList) {
                                if (markEntity.getStudent_id().equals(student.getStudent_id()) && markEntity.getEvaluation_criteria_id().equals(object.getEvaluationcriteria_id())) {
                                    caMarks.add(new ObjectDTO(markEntity.getAssignment_name(), markEntity.getAssignment_score()!=null?markEntity.getAssignment_score():"-","score"));
                                }
                            }
                            for (Calculations calculation : calculations) {
                                if (calculation.getStudent_id().equals(student.getStudent_id()) && calculation.getEvaluation_criteria_id().equals(object.getEvaluationcriteria_id())) {
                                    caMarks.add(new ObjectDTO(object.getDescription(), calculation.getMark()!=null?calculation.getMark():"-","average"));
                                }
                            }
                        } else {
                            for (MarksEntity markEntity : marksEntityList) {
                                if (markEntity.getStudent_id().equals(student.getStudent_id()) && markEntity.getEvaluation_criteria_id().equals(object.getEvaluationcriteria_id())) {
                                    caMarks.add(new ObjectDTO(markEntity.getAssignment_name(), markEntity.getAssignment_score()!=null?markEntity.getAssignment_score():"-","score"));
                                }
                            }
                        }
                        for (Calculations calculation : calculations) {
                            if (calculation.getStudent_id().equals(student.getStudent_id()) && calculation.getEvaluation_criteria_id().equals(object.getEvaluationcriteria_id())) {
                                caMarks.add(new ObjectDTO(object.getPercentage() + "% from " + object.getAssessment_type(), calculation.getPercentage()!=null?calculation.getPercentage():"-","percentage"));
                            }
                        }
                    }
                }





                for (EvaluationCriteria object : evaluationCriteriaList) {
                    if (object.getType().equals("End")) {
                        end = true;

                        for (MarksEntity markEntity : marksEntityList) {
                            if (markEntity.getStudent_id().equals(student.getStudent_id()) && markEntity.getEvaluation_criteria_id().equals(object.getEvaluationcriteria_id())) {
                                endMarks.add(new ObjectDTO(markEntity.getAssignment_name(), markEntity.getAssignment_score()!=null?markEntity.getAssignment_score():"-" ,"score"));

                                for (Calculations calculation : calculations) {
                                    if (calculation.getStudent_id().equals(student.getStudent_id()) && calculation.getEvaluation_criteria_id().equals(markEntity.getEvaluation_criteria_id()) && !markEntity.getAssignment_name().equalsIgnoreCase("1st Marking") &&  !markEntity.getAssignment_name().equalsIgnoreCase("2nd Marking")  ) {
                                        endMarks.add(new ObjectDTO(object.getPercentage() + "% from " + object.getAssessment_type(), calculation.getPercentage()!=null?calculation.getPercentage():"-","percentage"));
                                    }
                                }
                            }
                        }
                    }

                }


                Student studentDetails=studentRepo.getStudentDetailsByStudentID((student.getStudent_id()));

                StudentData newstudent = new StudentData();
                newstudent.setStudent_id(student.getStudent_id());
                newstudent.setStudent_name(studentDetails.getName_with_initials());
                newstudent.setCa(caMarks);
                newstudent.setEnd(endMarks);




                    for (StudentMarks studentmark : studentMarksList) {
                        if (studentmark.getStudent_id().equals(student.getStudent_id())) {
                            newstudent.setTotal_final_marks(studentmark.getTotal_final_mark() != null ? studentmark.getTotal_final_mark() : "-");
                            newstudent.setTotal_rounded_marks(studentmark.getTotal_rounded_mark() != null ? studentmark.getTotal_rounded_mark() : "-");
                            newstudent.setGrade(studentmark.getGrade() != null ? studentmark.getGrade() : "-");
                            newstudent.setGpv(studentmark.getGpv() != null ? studentmark.getGpv() : "-");
                            if (CA) {
                                newstudent.setTotal_ca_mark(studentmark.getTotal_ca_mark()!= null ? studentmark.getTotal_ca_mark() : "-");
                                newstudent.setCa_eligibility(studentmark.getCa_eligibility()!=null?  studentmark.getCa_eligibility():"-" );
                            }else
                            {
                                newstudent.setTotal_ca_mark("-");
                                newstudent.setCa_eligibility("-");
                            }
                        }
                    }
                list.add(newstudent);
            }

            return list;
        }

    }
