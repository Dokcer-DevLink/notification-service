package com.goorm.devlink.notificationservice.controller;


import com.goorm.devlink.notificationservice.dto.NotifyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NotificationController {

    @KafkaListener(
            topics = "#{'${data.kafka.topicName}'}",
            groupId = "#{'${data.kafka.groupId}'}"
    )
    public void listen(NotifyDto notifyDto){
        log.info(notifyDto.toString());
    }
}
