package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.Lecture;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Lecture.LectureCourseAssigned;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface LectureCourseAssignedRepository extends JpaRepository<LectureCourseAssigned,Integer> {


    //Search course ID by using username
    Page<LectureCourseAssigned> findLectureCourseAssignedByUsername(@RequestParam("userName") String userName, Pageable pageable);

}
