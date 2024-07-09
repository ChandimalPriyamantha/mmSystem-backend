package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.VC;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.VC.LevelForVC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApprovedLevelForVC extends JpaRepository<LevelForVC,Integer> {


        @Query("SELECT l FROM LevelForVC l WHERE l.approvalLevel = 'HOD'")
        Page<LevelForVC> findByApprovalLevelHOD(Pageable pageable);

}
