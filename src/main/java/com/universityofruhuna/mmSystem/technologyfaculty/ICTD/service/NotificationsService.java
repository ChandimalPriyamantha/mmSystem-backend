package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.NotificationsDTO;
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

    public void sendNotifications(NotificationsDTO notificationsDTO)
    {
        notificationsRepo.save(modelMapper.map(notificationsDTO, NotificationsEntity.class));
    }
}
