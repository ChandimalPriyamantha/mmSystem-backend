package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.CourseNameIdDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.CourseRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.CourseEntity;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseService {

        @Autowired
        private CourseRepo courseRepo;

        @Autowired
        private ModelMapper modelMapper;


        @Autowired
        ResponseDTO responseDTO;



        public List<CourseDTO> findCidCnameByLS(int level, int sem) {



                List<CourseEntity> list = courseRepo.findCCApprovedCourses(level, sem, Year.of(LocalDate.now().getYear()));
                List<CourseDTO> courseDTOList=modelMapper.map(list,new TypeToken<ArrayList<CourseDTO>>(){}.getType());

               return courseDTOList;


        }


        public ResponseDTO getAllCourses(){
                List<CourseEntity> courseEntities = courseRepo.findAll();
                if (courseEntities.isEmpty()){
                        responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
                        responseDTO.setContent(null);
                        responseDTO.setMessage("Courses not found!");
                }else {
                        responseDTO.setCode(VarList.RIP_SUCCESS);
                        responseDTO.setContent(modelMapper.map(courseEntities,new TypeToken<ArrayList<CourseDTO>>(){}.getType()));
                        responseDTO.setMessage("Courses found!");
                }
                return responseDTO;
        }
        public ResponseDTO insertCoursesAsBulk(List<CourseDTO> courseDTOS){
               List<CourseEntity> coursesAsBulk  = modelMapper.map(courseDTOS,new TypeToken<ArrayList<CourseEntity>>(){}.getType());
               try {
                       courseRepo.saveAll(coursesAsBulk);
                       responseDTO.setCode(VarList.RIP_SUCCESS);
                       responseDTO.setContent(courseDTOS);
                       responseDTO.setMessage("Courses have been inserted");
               }catch (Exception e){
                       responseDTO.setCode(VarList.RIP_ERROR);
                       responseDTO.setContent(courseDTOS);
                       responseDTO.setMessage(e.getMessage());
               }
        }
        public ResponseDTO insertACourse(){}
        public ResponseDTO getACourseById(){}
        public ResponseDTO updateACourseById(){}
        public ResponseDTO deleteACourseById(){}



}
