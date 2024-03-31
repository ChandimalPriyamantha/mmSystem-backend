package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.CourseRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.CourseEntity;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseService {

        @Autowired
        private CourseRepo courseRepo;

        @Autowired
        private ModelMapper modelMapper;

        public List<CourseDTO>  findCidCnameByLS(int level,int sem){
                List<CourseEntity> list =courseRepo.FindCourseCodeAndNameByLS(level,sem);
                return modelMapper.map(list,new TypeToken<ArrayList<CourseDTO>>(){}.getType());
        }
}
