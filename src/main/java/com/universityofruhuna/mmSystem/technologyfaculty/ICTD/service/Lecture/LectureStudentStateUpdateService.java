package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture.StudentCourseEnrollRepository;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.StudentCourseEnroll;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LectureStudentStateUpdateService {

    private StudentCourseEnrollRepository studentCourseEnrollRepository; // create the object for studentCourseEnroll entity
    private Pageable pageable;

    @Autowired // Initialization student course Enroll Repository
    public LectureStudentStateUpdateService(StudentCourseEnrollRepository studentCourseEnrollRepository) {
        this.studentCourseEnrollRepository = studentCourseEnrollRepository;
    }

    public void updateStudentState(String courseId, String assignmentType, String studentId) throws Exception {
        Page<StudentCourseEnroll> studentCourseEnrollPage = studentCourseEnrollRepository.findStudentCourseEnrollByStudentIdAndAssignmentNameAndStudentId(courseId, assignmentType,studentId, pageable);

        if (studentCourseEnrollPage.isEmpty()) {
            throw new Exception("No student enrolled in the course with courseId: " + courseId + " and assignmentType: " + assignmentType);
        }

        // Assuming you want to update all student course enrollments in this page
        List<StudentCourseEnroll> studentCourseEnrollList = studentCourseEnrollPage.getContent();
        for (StudentCourseEnroll studentCourseEnroll : studentCourseEnrollList) {
            studentCourseEnroll.setAssignmentName("Completed");
            studentCourseEnrollRepository.save(studentCourseEnroll);
        }
    }
}
