package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.controller;


import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.NotificationsDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.DTO.ResponseDTO;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.Util.VarList;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service.NotificationsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity sendNotification(@RequestBody NotificationsDTO notificationsDTO)
    {
       ResponseDTO responseDTO= notificationsService.sendNotifications(notificationsDTO);
        if(responseDTO.getCode().equals(VarList.RIP_SUCCESS))
        {
            return new ResponseEntity(responseDTO, HttpStatus.OK);
        }
        else
            return new ResponseEntity(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
