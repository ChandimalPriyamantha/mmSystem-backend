package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.AR;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.AR.ResultBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARResultBoardRepo extends JpaRepository<ResultBoard,Integer>{

    //Get result board availability
    @Query(nativeQuery = true, value = "select * from result_board where department= :department AND level= :level AND semester= :semester AND academic_year= :academic_year")
    List<ResultBoard> isResultBoardAvailable(String department, String level, String semester, String academic_year);

    //Get created result board list
    @Query(nativeQuery = true, value="select * from result_board where status != 'End' order by academic_year desc , semester desc, result_board.level asc, department desc")
    List <ResultBoard> getCreatedResultBoardList();
}
