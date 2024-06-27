package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.ResultBoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARResultBoardMemberRepo extends JpaRepository<ResultBoardMember,Integer> {
    @Query(nativeQuery = true, value= "select user.user_id, user.name_with_initials, user.user_name, course.course_id, course.course_name from result_board_member inner join user on result_board_member.course_coordinator_id= user.user_id inner join course on result_board_member.course_id = course.course_id where result_board_id = :result_board_id")     //Get all assigned marks sheets by result board id
    public List<Object> getAssignedMarksSheetsByResultBoardID(int result_board_id);
}
