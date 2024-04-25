package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.NotificationsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.NotificationsRepo;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.NotificationsEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NotificationsService
{
    @Autowired
    private NotificationsRepo notificationsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDTO responseDTO;

    public ResponseDTO sendNotifications(NotificationsDTO notificationsDTO)
    {
        try {
            notificationsRepo.save(modelMapper.map(notificationsDTO, NotificationsEntity.class));
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(notificationsDTO);
            responseDTO.setMessage("Successfully send the notification");
        }catch (Exception error)
        {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(notificationsDTO);
            responseDTO.setMessage("Error sending the notification");
        }
        return responseDTO;
    }
}
