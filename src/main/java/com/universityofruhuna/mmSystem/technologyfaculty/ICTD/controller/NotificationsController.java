package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.NotificationsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.NotificationsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/notifications")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationsController
{
    @Autowired
    private NotificationsService notificationsService;

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody NotificationsDTO notificationsDTO)
    {
        notificationsService.sendNotifications(notificationsDTO);
    }
}
