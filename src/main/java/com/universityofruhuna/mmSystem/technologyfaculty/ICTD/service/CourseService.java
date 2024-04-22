package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.AR.CourseDTO;
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
import java.util.Optional;

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
               return responseDTO;
        }
        public ResponseDTO insertACourse(CourseDTO courseDTO){
                CourseEntity insertOneCourse = modelMapper.map(courseDTO,CourseEntity.class);
                try {
                        courseRepo.save(insertOneCourse);
                        responseDTO.setCode(VarList.RIP_SUCCESS);
                        responseDTO.setContent(courseDTO);
                        responseDTO.setMessage("Course has been inserted");
                }catch (Exception e){
                        responseDTO.setCode(VarList.RIP_ERROR);
                        responseDTO.setContent(courseDTO);
                        responseDTO.setMessage(e.getMessage());
                }
                return responseDTO;
        }
        public ResponseDTO getACourseById(int id){
                if (courseRepo.existsById(id)){
                        Optional<CourseEntity> courseById = courseRepo.findById(id);
                        responseDTO.setCode(VarList.RIP_SUCCESS);
                        responseDTO.setContent(courseById);
                        responseDTO.setMessage("Data found");

                }else {
                        responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
                        responseDTO.setContent(null);
                        responseDTO.setMessage("Data not found");
                }
                return responseDTO;
        }
        public ResponseDTO updateACourseById(CourseDTO courseDTO){
                CourseEntity updateOneCourseById = modelMapper.map(courseDTO,CourseEntity.class);
                try {
                        courseRepo.save(updateOneCourseById);
                        responseDTO.setCode(VarList.RIP_SUCCESS);
                        responseDTO.setContent(courseDTO);
                        responseDTO.setMessage("Course has been updated");
                }catch (Exception e){
                        responseDTO.setCode(VarList.RIP_ERROR);
                        responseDTO.setContent(courseDTO);
                        responseDTO.setMessage(e.getMessage());
                }
                return responseDTO;
        }
        public ResponseDTO deleteACourseById(int id){
                if (courseRepo.existsById(id)){
                        courseRepo.deleteById(id);
                        responseDTO.setCode(VarList.RIP_SUCCESS);
                        responseDTO.setContent(id);
                        responseDTO.setMessage("Course has been deleted");
                }else {
                        responseDTO.setCode(VarList.RIP_ERROR);
                        responseDTO.setContent(id);
                        responseDTO.setMessage("Course id not found");
                }
                return responseDTO;
        }



}
